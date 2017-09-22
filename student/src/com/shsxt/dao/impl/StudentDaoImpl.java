package com.shsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shsxt.dao.StudentDao;
import com.shsxt.entity.Student;
import com.shsxt.util.DBUtil;
import com.shsxt.util.StringUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> queryAll() {
		List<Student> list = new ArrayList<Student>();
		Connection conn = DBUtil.getConn();
		StringBuilder sql = new StringBuilder();
		sql.append(" select student_id,student_name,age,sex,grade,birthday,create_date,update_date,is_available ");
		sql.append(" from t_student ");
		sql.append(" where is_available=1 ");
		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		ResultSet rs = DBUtil.getResultSet(ps);
		if (rs != null) {
			try {
				while (rs.next()) {
					Student student = new Student();
					student.setStudentId(rs.getInt("student_id"));
					student.setStudentName(rs.getString("student_name"));
					student.setAge(rs.getInt("age"));
					student.setSex(rs.getInt("sex"));
					student.setGrade(rs.getString("grade"));
					student.setBirthday(rs.getTimestamp("birthday"));
					student.setCreateDate(rs.getTimestamp("create_date"));
					student.setUpdateDate(rs.getTimestamp("update_date"));
					list.add(student);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.close(rs);
				DBUtil.close(ps);
				DBUtil.colse(conn);
			}
		}
		return list;
	}

	@Override
	public List<Student> queryAllStudent(int startIndex, int pageSize) {
		List<Student> list = new ArrayList<Student>();
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select student_id,student_name,age,sex,grade,birthday,create_date,update_date ");
		sql.append(" from t_student ");
		sql.append(" where is_available=1 ");
		sql.append(" limit ?, ? ");

		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		try {
			ps.setInt(1, startIndex);
			ps.setInt(2, pageSize);
			rs = DBUtil.getResultSet(ps);
			if (rs != null) {
				while (rs.next()) {
					Student student = new Student();
					student.setStudentId(rs.getInt("student_id"));
					student.setStudentName(rs.getString("student_name"));
					student.setAge(rs.getInt("age"));
					student.setSex(rs.getInt("sex"));
					student.setGrade(rs.getString("grade"));
					student.setBirthday(rs.getTimestamp("birthday"));
					student.setCreateDate(rs.getTimestamp("create_date"));
					student.setUpdateDate(rs.getTimestamp("update_date"));
					list.add(student);
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.colse(conn);
		}
		return list;
	}

	@Override
	public void deleteStudentByStudentId(int studentId) {
		Connection conn = DBUtil.getConn();
		StringBuilder sql = new StringBuilder();
		sql.append(" update t_student ");
		sql.append(" set is_available=0 ");
		sql.append(" where student_id=? ");
		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		try {
			ps.setInt(1, studentId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.colse(conn);
		}

	}

	@Override
	public void add(String studentName, int age, String grade, int sex, String birthday) {
		Connection conn = DBUtil.getConn();
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO t_student ");
		sql.append(" (student_name,age,sex,grade,birthday,create_date,is_available ) ");
		sql.append(" VALUES(?,?,?,?,?,?,?) ");

		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		try {
			ps.setString(1, studentName);
			ps.setInt(2, age);
			ps.setInt(3, sex);
			ps.setString(4, grade);
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.setDate(5, new java.sql.Date(date.getTime()));
			ps.setTimestamp(6, new Timestamp(new Date().getTime()));
			ps.setInt(7, 1);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			DBUtil.close(ps);
			DBUtil.colse(conn);
		}

	}

	@Override
	public Student queryStudentByStudentId(int studentId) {
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		Student student = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select student_id,student_name,age,sex,grade,birthday,create_date,update_date ");
		sql.append(" from t_student ");
		sql.append(" where is_available=1 ");
		sql.append(" and student_id=? ");
		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		try {
			ps.setInt(1, studentId);
			rs = DBUtil.getResultSet(ps);
			if (rs != null) {
				while (rs.next()) {
					student = new Student();
					student.setStudentId(rs.getInt("student_id"));
					student.setStudentName(rs.getString("student_name"));
					student.setAge(rs.getInt("age"));
					student.setSex(rs.getInt("sex"));
					student.setGrade(rs.getString("grade"));
					student.setBirthday(rs.getTimestamp("birthday"));
					student.setCreateDate(rs.getTimestamp("create_date"));
					student.setUpdateDate(rs.getTimestamp("update_date"));
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
		return student;
	}

	@Override
	public void updateStudentByStudentId(int studentId, String studentName, int age, int sex, String grade,
			String birthday) {
		Connection conn = DBUtil.getConn();
		StringBuilder sql = new StringBuilder();
		sql.append(" update t_student ");
		sql.append(" set student_name=?,age=?,grade=?,sex=?,birthday=?,update_date=? ");
		sql.append(" where is_available=1 and student_id=? ");

		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		try {
			ps.setString(1, studentName);
			ps.setInt(2, age);
			ps.setString(3, grade);
			ps.setInt(4, sex);
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy/MM/dd").parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.setDate(5, (java.sql.Date) date);
			ps.setTimestamp(6, new Timestamp(new Date().getTime()));
			ps.setInt(7, studentId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.colse(conn);
		}

	}

	@Override
	public List<Student> queryStudentTotalRecord(String studentName, int sex) {
		List<Student> students = null;
		students = new ArrayList<Student>();
		Connection conn = DBUtil.getConn();
		StringBuilder sql = new StringBuilder();
		sql.append(" select student_id,student_name,age,birthday,sex,grade,create_date,update_date,is_available ");
		sql.append(" from t_student where ");
		sql.append(" is_available=1 ");
		if (!StringUtil.isEmpty(studentName)) {
			sql.append("and student_name=? ");
		}
		if (2 != sex) {
			sql.append("and sex=? ");
		}
		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		int index = 0;
		if (!StringUtil.isEmpty(studentName)) {
			try {
				ps.setString(++index, studentName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (2 != sex) {
			try {
				ps.setInt(++index, sex);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ResultSet rs = DBUtil.getResultSet(ps);
		if (rs == null) {
			return null;
		}
		try {
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setAge(rs.getInt("age"));
				student.setBirthday(rs.getTimestamp("birthday"));
				student.setSex(rs.getInt("sex"));
				student.setGrade(rs.getString("grade"));
				student.setCreateDate(rs.getTimestamp("create_date"));
				student.setUpdateDate(rs.getTimestamp("update_date"));
				student.setIsAvailable(rs.getInt("is_available"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.colse(conn);
		}
		return students;
	}

	@Override
	public List<Student> queryStudent(String studentName, int sex, int startIndex, int pageSize) {
		List<Student> students = null;
		students = new ArrayList<Student>();
		ResultSet rs = null;
		Connection conn = DBUtil.getConn();
		StringBuilder sql = new StringBuilder();
		sql.append(" select student_id,student_name,age,birthday,sex,grade,create_date,update_date,is_available ");
		sql.append(" from t_student where ");
		sql.append(" is_available=1 ");
		if (!StringUtil.isEmpty(studentName)) {
			sql.append("and student_name=? ");
		}
		if (2 != sex) {
			sql.append("and sex=? ");
		}
		sql.append(" limit ?,? ");
		PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql.toString());
		int index = 0;
		if (!StringUtil.isEmpty(studentName)) {
			try {
				ps.setString(++index, studentName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (2 != sex) {
			try {
				ps.setInt(++index, sex);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			ps.setInt(++index, startIndex);
			ps.setInt(++index, pageSize);
			rs = DBUtil.getResultSet(ps);
			if (rs == null) {
				return null;
			}
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setAge(rs.getInt("age"));
				student.setBirthday(rs.getDate("birthday"));
				student.setSex(rs.getInt("sex"));
				student.setGrade(rs.getString("grade"));
				student.setCreateDate(rs.getTimestamp("create_date"));
				student.setUpdateDate(rs.getTimestamp("update_date"));
				student.setIsAvailable(rs.getInt("is_available"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.colse(conn);
		}
		return students;
	}

}
