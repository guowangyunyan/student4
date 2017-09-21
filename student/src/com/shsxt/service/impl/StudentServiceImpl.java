package com.shsxt.service.impl;

import java.util.List;

import com.shsxt.dao.StudentDao;
import com.shsxt.dao.impl.StudnetDaoImpl;
import com.shsxt.entity.Page;
import com.shsxt.entity.Student;
import com.shsxt.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;

	public StudentServiceImpl() {
		studentDao = new StudnetDaoImpl();
	}

	@Override
	public Page<Student> queryAllStudentWithPage(int currentPage, int pageSize) {
		List<Student> list = studentDao.queryAll();
		int totalRecord = list.size();
		Page<Student> students = new Page<Student>(currentPage, pageSize, totalRecord);
		int startPage = (currentPage - 1) * pageSize;
		students.setList(studentDao.queryAllStudent(startPage, pageSize));
		return students;
	}

	@Override
	public void deleteStudentByStudentId(String studentIdStr) {
		int studentId = Integer.parseInt(studentIdStr);
		studentDao.deleteStudentByStudentId(studentId);
	}

	@Override
	public void add(String studentName, String ageStr, String grade, String sexStr, String birthday,
			String createDate) {
		int age = Integer.parseInt(ageStr);
		int sex = Integer.parseInt(sexStr);
		studentDao.add(studentName, age, grade, sex, birthday, createDate);
	}

	@Override
	public Student queryStudentByStudentId(String studentIdStr) {
		int studentId = Integer.parseInt(studentIdStr);
		Student student = studentDao.queryStudentByStudentId(studentId);
		return student;
	}

	@Override
	public void updateStudentByStudentId(String studentIdStr, String studentName, String grade, String ageStr,
			String sexStr, String birthday, String updateDate) {
		int studentId = Integer.parseInt(studentIdStr);
		int age = Integer.parseInt(ageStr);
		int sex = Integer.parseInt(sexStr);
		studentDao.updateStudentByStudentId(studentId, studentName, age, sex, grade, birthday, updateDate);

	}

}
