package com.shsxt.dao;

import java.util.List;

import com.shsxt.entity.Student;

public interface StudentDao {

	List<Student> queryAll();

	List<Student> queryAllStudent(int startPage, int pageSize);

	void deleteStudentByStudentId(int studentId);

	void add(String studentName, int age, String grade, int sex, String birthday, String createDate);

	void updateStudentByStudentId(int studentId, String studentName, int age, int sex, String grade, String birthday,
			String updateDate);

	Student queryStudentByStudentId(int studentId);

}
