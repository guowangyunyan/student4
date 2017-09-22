package com.shsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shsxt.dao.UserDao;
import com.shsxt.entity.User;
import com.shsxt.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User queryUserByUnameAndPwd(String uname, String pwd) {
		User user = null;
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select user_id,user_name,user_pwd ,is_available ");
		sql.append(" from t_user ");
		sql.append(" where is_available=1 and user_name=? and user_pwd=? ");
		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		try {
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs = DBUtil.getResultSet(ps);
			if (rs != null) {
				while (rs.next()) {
					user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setUname(rs.getString("user_name"));
					user.setPwd(rs.getString("user_pwd"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.colse(conn);
		}
		return user;
	}

}
