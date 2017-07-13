package com.news.dao;

import org.apache.ibatis.annotations.Param;
import com.news.model.User;

public interface UserDao {

	public void register(User user);
	public User getUserByName(String account);
	public void deleteAccount(String account);
	public void updateKeywords(@Param("keywords")String keywords, @Param("account")String account);
}
