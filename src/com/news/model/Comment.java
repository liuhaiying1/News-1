package com.news.model;

import java.util.ArrayList;
import java.util.List;

public class Comment {
	private int comment_id;
	private int ID;
	private String account;
	private String content;
	private int zan;
	private String date;
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getZan() {
		return zan;
	}

	public void setZan(int zan) {
		this.zan = zan;
	}

	public Comment(){}
	
	public Comment(int ID, String account, String content){
		this.ID = ID;
		this.account = account;
		this.content = content;
	}
	
	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getComment() {
		return content;
	}

	public void setComment(String comment) {
		this.content = comment;
	}
	
	public static List<Comment> getCommentsByID(int ID, List<Comment> commentList){
		
		List<Comment> list = new ArrayList<Comment>();
		for(Comment c: commentList){
			if(c.getID()==ID){
				list.add(c);
				System.out.println(c.getComment());
			}
		}
		
		return list;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
