package com.news.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class News {
	int ID;
	String img;
	String title;
	String preview;
	String content;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	String author;
	String date;

	String keywords;
	List<String> contentList = new ArrayList<String>();
	List<String> keywordsList = new ArrayList<String>();
	
	public News(){}
	
	public News(String img, String title, String preview, String content, String keywords, String author, String date){
		this.img = img;
		this.title = title;
		this.preview = preview;
		this.content = content;
		this.keywords = keywords;
		this.author = author;
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public int getID() {
		return ID;
	}

	public String getImg() {
		return img;
	}

	public String getTitle() {
		return title;
	}

	public String getPreview() {
		return preview;
	}

	public  List<String> getContentList(){
		String s = content.replaceAll(" class=\"report-view\"", "");
		s = s.substring(1, s.length()-1);
		String[] s2 = s.split(", <p");
		for(int i=1;i<s2.length;i++){
			s2[i] = "<p"+s2[i];
		}
		List<String> list = Arrays.asList(s2);
		
		return list;
	}
	
	public  List<String> getKeywordsList(){
		String s = keywords;
		s = s.substring(1, s.length()-1);
		String[] s2 = s.split(", ");
		List<String> list = Arrays.asList(s2);
		return list;
	}
	
	public String getKeywords(){
		return keywords;
	}
	
	@Override
	public String toString(){
		
		String rs = "";
		rs += title + "\n" + keywords;
		
		return rs;
		
	}
	
}
