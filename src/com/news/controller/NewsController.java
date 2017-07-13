package com.news.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.news.model.Comment;
import com.news.model.News;
import com.news.model.User;
import com.news.service.CommentService;
import com.news.service.NewsService;
import com.news.service.UserService;

@Controller
public class NewsController {

	private NewsService newsService;
	private CommentService commentService;
	private UserService userService;

	@Resource
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@RequestMapping("updateNews.do")
	public ModelAndView updateNews() {
		System.out.println("updateNews.do");
		newsService.updateNews();
		System.out.println("updateNews complete");
		ModelAndView modelAndView = new ModelAndView("index.do");
		return modelAndView;
	}

	@RequestMapping("showPage.do")
	public ModelAndView showPage(HttpServletRequest req) {
		System.out.println("showPage.do");
		int newsID = Integer.parseInt(req.getParameter("newsID"));
		String account = req.getParameter("account_login");
		Map<String, Object> map = new HashMap<String, Object>();
		News news = newsService.getNewsByID(newsID);
		List<News> recommendList = new ArrayList<News>();
		int newsID2 = newsID;
		for (int i = 1; i < 8; i++) {
			News n = newsService.getNewsByID(newsID2 + i);
			if (n != null)
				recommendList.add(n);
			else
				newsID2 -= 10;
		}
		map.put("news", news);
		List<Comment> commentList = commentService.getCommentsByID(newsID);
		map.put("commentList", commentList);
		map.put("recommendList", recommendList);
		map.put("account", account);
		ModelAndView modelAndView = new ModelAndView("/page.jsp", map);
		System.out.println("showPage.do complete");
		return modelAndView;
	}

	@RequestMapping("index.do")
	public ModelAndView setNews(HttpServletRequest req) {
		System.out.println("index.do");
		Map<String, Object> map = new HashMap<String, Object>();
		String account = req.getParameter("account_login");
		User user = userService.getUserByName(account);
		List<News> newsList = newsService.getNews(user);
		
		map.put("newsList", newsList);
		map.put("account_login", account);
		System.out.println("index.do complete");
		return new ModelAndView("index.jsp", map);
	}

}
