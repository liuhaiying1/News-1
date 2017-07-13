package com.news.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.news.model.Comment;

public interface CommentDao {
	public void addComment(Comment comment);
	public List<Comment> getCommentsByID(int ID);
	public void deleteComment(int comment_id);
	public void updateZan(@Param("zan") int zan, @Param("comment_id")int comment_id);
}
