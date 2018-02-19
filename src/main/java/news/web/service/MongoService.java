package news.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import news.web.model.Article;
import news.web.model.ParaGraph;
import news.web.model.Slide;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Service
public class MongoService implements DataServiceI {
	MongoClient mongoClient;
	private MongoDatabase db;

	@PostConstruct
	public void inti() {
		mongoClient = new MongoClient("localhost", 27017);
		db = mongoClient.getDatabase("news");
		//		db.authenticate(myUserName, myPassword);
	}

	@PreDestroy
	public void cleanUp() {
		if (mongoClient != null) {
			mongoClient.close();
		}
	}

	@Override
	public List<Slide> getHome() {
		List<Slide> slides = new ArrayList<>();
		MongoCursor<Document> it = db.getCollection("slides").find().iterator();
		while (it.hasNext()) {
			Document doc = it.next();
			slides.add(new Slide(doc.getString("link"), doc.getString("img"), doc.getString("title"), doc.getString("desc")));
		}
		return slides;
	}

	@Override
	public Article getArticle(int id) {
		Bson bson = new Document("id", id);
		FindIterable<Document> it = db.getCollection("article").find(bson);
		Document doc = it.first();
		if (doc == null) {
			return null;
		} else {
			Article article = new Article();
			article.setId(id);
			article.setImage(doc.getString("image"));
			article.setTitle(doc.getString("title"));
			article.setUrl(doc.getString("url"));
			article.setUrlText(doc.getString("urlText"));
			article.setContent(new ArrayList<ParaGraph>());
			@SuppressWarnings("unchecked")
			List<Document> content = (List<Document>) doc.get("content");
			for (Document pg : content) {
				ParaGraph paraGraph = new ParaGraph();
				paraGraph.setImg(pg.getString("img"));
				paraGraph.setText(pg.getString("text"));
				article.getContent().add(paraGraph);
			}
			return article;
		}
	}

}
