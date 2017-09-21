package com.shsxt.dao;

import com.shsxt.entity.User;
import com.shsxt.entity.vo.ResultInfo;

public interface UserDao {

	ResultInfo<User> queryUserByUnameAndPwd(User user);

}
