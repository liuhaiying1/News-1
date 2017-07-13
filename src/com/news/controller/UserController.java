package com.news.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.news.model.News;
import com.news.model.User;
import com.news.service.NewsService;
import com.news.service.UserService;

@Controller
public class UserController {
	private UserService userService;
	private NewsService newsService;

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource
	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	@RequestMapping("register.do")
	public ModelAndView register(User user) throws IOException {
		User user2 = userService.getUserByName(user.getAccount());

		if (user2 == null) {
			userService.register(user);
		}
		return new ModelAndView("./index.do");// 注册后登录登陆后，注册按钮和登录按钮改变，编程
	}

	 @RequestMapping("login.do")
	    public ModelAndView login(HttpServletRequest req)
	    {
	    	//判断是否正确登录，是：则login.do,cishi login.do页面登录注册按钮部分改成Welcome +account,否：则不予通过，或仍在之前的login.do
	    	String account_login=req.getParameter("account_login");
	    	if(userService.getUserByName(account_login)==null)
	    	{
	    		return new ModelAndView("./index.do?account_login="+"");
	    	}
	    	return new ModelAndView("./index.do?account_login="+account_login);
	    }

	@RequestMapping("deleteAccount.do")
	public void deleteAccount(HttpServletRequest req) {
		String account = req.getParameter("account_login");
		userService.deleteAccount(account);
	}

	@RequestMapping("dislike.do")
	public void dislike(HttpServletRequest req, HttpServletResponse res) throws IOException {

		String account = req.getParameter("account");
		int newsID = Integer.parseInt(req.getParameter("newsID"));
		News news = newsService.getNewsByID(newsID);
		User user = userService.getUserByName(account);
		List<String> keywords = news.getKeywordsList();
		
		String keywords_u = user.getKeywords();

		for (String k : keywords) {
			keywords_u += k + " ";
		}

		userService.updateKeywords(keywords_u, account);
		PrintWriter pw = res.getWriter();
		pw.write(1);
	}
}