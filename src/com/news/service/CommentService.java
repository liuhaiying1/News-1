package com.news.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.news.dao.CommentDao;
import com.news.model.Comment;

@Service
public class CommentService {

	@Resource
	private CommentDao commentDao;

	public void addComment(Comment comment) {
		commentDao.addComment(comment);
	}

	public List<Comment> getCommentsByID(int ID) {
		return commentDao.getCommentsByID(ID);
	}
	
	public void deleteComment(int comment_id){
		commentDao.deleteComment(comment_id);
	}
	
	public void updateZan(int zan, int comment_id){
		commentDao.updateZan(zan, comment_id);
	}
}
