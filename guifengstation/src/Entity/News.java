package Entity;

public class News {
     private int nid;
     private String title;
     private String author;
     private String time;
     private String content;
	 private String img;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public News(int nid, String title, String author, String time,
			String content, String img) {
		super();
		this.nid = nid;
		this.title = title;
		this.author = author;
		this.time = time;
		this.content = content;
		this.img = img;
	}
	public News() {
		super();
	}
	 
     
}
