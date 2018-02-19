package news.web.service;

import java.util.List;

import news.web.model.Article;
import news.web.model.Slide;

public interface DataServiceI {

	List<Slide> getHome();

	Article getArticle(int id);
}
