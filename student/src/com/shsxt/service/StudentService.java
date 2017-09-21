package com.shsxt.service;

import com.shsxt.entity.Page;
import com.shsxt.entity.Student;

public interface StudentService {

	Page<Student> queryAllStudentWithPage(int currentPage, int pageSize);

	void deleteStudentByStudentId(String studentIdStr);

	void add(String studentName, String ageStr, String grade, String sexStr, String birthday, String createDate);

	void updateStudentByStudentId(String studentIdStr, String studentName, String grade, String ageStr, String sexStr,
			String birthday, String updateDate);

	Student queryStudentByStudentId(String studentIdStr);

}
