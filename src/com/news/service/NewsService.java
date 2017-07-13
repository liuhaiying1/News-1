package com.news.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.news.dao.NewsDao;
import com.news.model.News;
import com.news.model.User;

@Service
public class NewsService {

	@Resource
	private NewsDao newsDao;

	public void updateNews() {
		newsDao.clearNews();
		List<News> newsList = new ArrayList<News>();
		ExtractNews.run(newsList);
		for (News n : newsList) {
			
			if(n.getContent().length()<10000)
				newsDao.addNews(n);
			
		}
		System.out.println("update newsList!");
		
	}

	public List<News> getNews(User user) {
		List<News> list = newsDao.getNews();
		Iterator<News> it = list.iterator();
		if (user != null) {
			String keywords_u = user.getKeywords();
			if (user.getKeywords() != null) {
				String[] keywordA = keywords_u.split(" ");
				while(it.hasNext()){
					News news = it.next();
					for (int j = 0; j < keywordA.length; j++) {
						if(keywordA.equals("")||keywordA.equals(",")||keywordA.equals(" "))
							continue;
						if (news.getKeywords().contains(keywordA[j])) {
							it.remove();
							break;
						}
					}
				}
			}
		}
		
		return list;
	}
	public News getNewsByID(int ID){
		return newsDao.getNewsByID(ID);
	}

}
