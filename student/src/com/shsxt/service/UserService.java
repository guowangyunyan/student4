package com.shsxt.service;

import com.shsxt.entity.User;
import com.shsxt.entity.vo.ResultInfo;

public interface UserService {

	ResultInfo<User> queryUserByUnameAndPwd(User user);

}
