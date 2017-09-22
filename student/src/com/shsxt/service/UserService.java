package com.shsxt.service;

import com.shsxt.entity.User;

public interface UserService {

	User queryUserByUnameAndPwd(String uname, String pwd);

}
