package Entity;

public class Contact {
    private String name;
    private String boxmail;
    private String content;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBoxmail() {
		return boxmail;
	}
	public void setBoxmail(String boxmail) {
		this.boxmail = boxmail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Contact(String name, String boxmail, String content) {
		super();
		this.name = name;
		this.boxmail = boxmail;
		this.content = content;
	}
	public Contact() {
		super();
	}
    
}
