package com.news.model;

public class Video {
	int video_id;
	String title;
	String content;
	String img;
	
	public Video(){}
	public Video(String title, String content, String img){
		this.title = title;
		this.content = content;
		this.img = img;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString(){
		
		String rs = "";
		rs += title + "\n" + content;
		
		return rs;
		
	}
}
