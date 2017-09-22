package com.shsxt.dao;

import com.shsxt.entity.User;

public interface UserDao {

	User queryUserByUnameAndPwd(String uname, String pwd);

}
