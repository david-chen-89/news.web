package news.web.model;

public class Slide {
	private String link;
	private String img;
	private String title;
	private String desc;

	public Slide(String link, String img, String title, String desc) {
		super();
		this.link = link;
		this.img = img;
		this.title = title;
		this.desc = desc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
