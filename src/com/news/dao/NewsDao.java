package com.news.dao;

import java.util.List;

import com.news.model.News;

public interface NewsDao {
	
	public void addNews(News news);
	public List<News> getNews();
	public News getNewsByID(int ID);
	public void clearNews();
}
