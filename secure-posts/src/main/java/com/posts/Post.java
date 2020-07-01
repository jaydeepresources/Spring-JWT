package com.posts;

public class Post {

	private Integer id;
	private String title;
	private String body;

	public Post() {

	}

	public Post(Integer id, String title, String body) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + "]";
	}

}
