package com.news.model;

public class User {
	String account;
	String password;
	String keywords;
	
	public User(){}
	public User(String acount, String password, String keywords){
		this.account = acount;
		this.password = password;
		this.keywords = keywords;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	
}
