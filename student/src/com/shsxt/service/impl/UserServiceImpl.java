package com.shsxt.service.impl;

import com.shsxt.dao.UserDao;
import com.shsxt.dao.impl.UserDaoImpl;
import com.shsxt.entity.User;
import com.shsxt.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public User queryUserByUnameAndPwd(String uname, String pwd) {
		User user = userDao.queryUserByUnameAndPwd(uname, pwd);
		return user;
	}
}
