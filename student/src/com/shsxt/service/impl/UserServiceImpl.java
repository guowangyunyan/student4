package com.shsxt.service.impl;

import com.shsxt.dao.UserDao;
import com.shsxt.dao.impl.UserDaoImpl;
import com.shsxt.entity.User;
import com.shsxt.entity.vo.ResultInfo;
import com.shsxt.service.UserService;
import com.shsxt.util.StringUtil;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public ResultInfo<User> queryUserByUnameAndPwd(User user) {
		ResultInfo<User> result = new ResultInfo<User>();
		String uname = user.getUname();
		String upwd = user.getPwd();
		if (StringUtil.isEmpty(uname) && StringUtil.isEmpty(upwd)) {
			result = userDao.queryUserByUnameAndPwd(user);
		} else {
			result.setCode(-1);
			result.setMsg("用户名或密码为空！");
			result.setObj(user);
		}

		return result;
	}

}
