package com.shsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shsxt.dao.UserDao;
import com.shsxt.entity.User;
import com.shsxt.entity.vo.ResultInfo;
import com.shsxt.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public ResultInfo<User> queryUserByUnameAndPwd(User user) {
		ResultInfo<User> result = new ResultInfo<User>();
		Connection conn = DBUtil.getConn();
		StringBuilder sql = new StringBuilder();
		sql.append(" select user_id,user_name,user_pwd is_available ");
		sql.append(" from t_user ");
		sql.append(" where is_available=1 and user_name=? and user_pwd=? ");
		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		try {
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPwd());
			ResultSet rs = DBUtil.getResultSet(ps);
			if (rs != null) {
				while (rs.next()) {
					User u = new User();
					u.setUserId(rs.getInt("user_id"));
					u.setUname(rs.getString("user_name"));
					u.setPwd(rs.getString("user_pwd"));
					result.setCode(1);
					result.setMsg("成功登录");
					result.setObj(u);
				}
			} else {
				result.setCode(-1);
				result.setMsg("用户名或密码错误");
				result.setObj(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
