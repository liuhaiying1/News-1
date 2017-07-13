package com.news.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.news.dao.UserDao;
import com.news.model.User;

@Service
public class UserService {
	private UserDao userDao;

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		userDao.register(user);
	}

	public User getUserByName(String account) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(account);
	}

	public void updateKeywords(String keywords, String account) {
		userDao.updateKeywords(keywords, account);
	}

	public void deleteAccount(String account) {
		// TODO Auto-generated method stub
		userDao.deleteAccount(account);
	}
}
