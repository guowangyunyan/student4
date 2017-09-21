package com.shsxt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(PropertiesUtil.get("jdbcName"));
			conn = DriverManager.getConnection(PropertiesUtil.get("dbUrl"), PropertiesUtil.get("dbUserName"),
					PropertiesUtil.get("dbPassword"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		PreparedStatement ps = null;
		try {
			if (conn != null) {
				ps = conn.prepareStatement(sql);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	public static ResultSet getResultSet(PreparedStatement ps) {
		ResultSet rs = null;
		try {
			if (ps != null) {
				rs = ps.executeQuery();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public static void colse(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
				ps = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
