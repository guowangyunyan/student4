package com.shsxt.dao;

import java.util.List;

import com.shsxt.entity.Student;

public interface StudentDao {

	List<Student> queryAll();

	List<Student> queryAllStudent(int startPage, int pageSize);

	void deleteStudentByStudentId(int studentId);

	void add(String studentName, int age, String grade, int sex, String birthday);

	void updateStudentByStudentId(int studentId, String studentName, int age, int sex, String grade, String birthday);

	Student queryStudentByStudentId(int studentId);

	List<Student> queryStudentTotalRecord(String studentName, int sex);

	List<Student> queryStudent(String studentName, int sex, int startIndex, int pageSize);

}
