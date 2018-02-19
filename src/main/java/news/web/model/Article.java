package news.web.model;

import java.util.List;

public class Article {
	private Integer id;
	private String urlText;
	private String url;
	private String title;
	private String image;
	private List<ParaGraph> content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrlText() {
		return urlText;
	}

	public void setUrlText(String urlText) {
		this.urlText = urlText;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<ParaGraph> getContent() {
		return content;
	}

	public void setContent(List<ParaGraph> content) {
		this.content = content;
	}

}
