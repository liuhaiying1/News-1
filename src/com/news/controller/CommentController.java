package com.news.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.news.model.Comment;
import com.news.service.CommentService;

@Controller
public class CommentController {
	private CommentService commentService;
	
	@Resource
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@RequestMapping("postComment.do")
	public ModelAndView postComment(HttpServletRequest req, HttpServletResponse res) throws IOException{
		System.out.println("postComment.do");
		int ID = Integer.parseInt(req.getParameter("newsID"));
		String account = req.getParameter("account");
		String content = req.getParameter("content");
		Comment comment = new Comment(ID, account, content);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curDate = s.format(c.getTime());
		System.out.println(curDate);
		comment.setDate(curDate);
		commentService.addComment(comment);
		List<Comment> commentList = commentService.getCommentsByID(ID);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentList", commentList);
		System.out.println("postComment complete");
		ModelAndView modelAndView = new ModelAndView("/showPage.do", map);
		return modelAndView;
	}
	
	@RequestMapping("deleteComment.do")
	public void deleteComment(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		int comment_id = Integer.parseInt(req.getParameter("comment_id"));
		
		commentService.deleteComment(comment_id);
		PrintWriter pw = res.getWriter();
		pw.write(1);
	}
	
	@RequestMapping("updateZan.do")
	public void updateZan(HttpServletRequest req, HttpServletResponse res) throws IOException{
		System.out.println("updateZan.do");
		int comment_id = Integer.parseInt(req.getParameter("comment_id"));
		int zan = Integer.parseInt(req.getParameter("zan"));
		int signal = Integer.parseInt(req.getParameter("signal"));
		if(signal==0){
			commentService.updateZan(zan, comment_id);
		}
		if(signal==1){
			commentService.updateZan(zan, comment_id);
		}
		
		PrintWriter pw = res.getWriter();
		pw.write("1");
		System.out.println("updateZan complete");
	}
	
}
