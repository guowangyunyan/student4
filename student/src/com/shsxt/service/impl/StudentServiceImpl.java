package com.shsxt.service.impl;

import java.util.List;

import com.shsxt.dao.StudentDao;
import com.shsxt.dao.impl.StudentDaoImpl;
import com.shsxt.entity.Page;
import com.shsxt.entity.Student;
import com.shsxt.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;

	public StudentServiceImpl() {
		studentDao = new StudentDaoImpl();
	}

	@Override
	public Page<Student> queryAllStudentWithPage(int currentPage, int pageSize) {
		List<Student> list = studentDao.queryAll();
		int totalRecord = list.size();
		Page<Student> page = new Page<Student>(currentPage, pageSize, totalRecord);
		int startIndex = (currentPage - 1) * pageSize;
		page.setList(studentDao.queryAllStudent(startIndex, pageSize));
		return page;
	}

	@Override
	public void deleteStudentByStudentId(String studentIdStr) {
		int studentId = Integer.parseInt(studentIdStr);
		studentDao.deleteStudentByStudentId(studentId);
	}

	@Override
	public void add(String studentName, String ageStr, String grade, String sexStr, String birthday) {
		int age = Integer.parseInt(ageStr);
		int sex = Integer.parseInt(sexStr);
		studentDao.add(studentName, age, grade, sex, birthday);
	}

	@Override
	public Student queryStudentByStudentId(String studentIdStr) {
		int studentId = Integer.parseInt(studentIdStr);
		Student student = studentDao.queryStudentByStudentId(studentId);
		return student;
	}

	@Override
	public void updateStudentByStudentId(String studentIdStr, String studentName, String grade, String ageStr,
			String sexStr, String birthday) {
		int studentId = Integer.parseInt(studentIdStr);
		int age = Integer.parseInt(ageStr);
		int sex = Integer.parseInt(sexStr);
		studentDao.updateStudentByStudentId(studentId, studentName, age, sex, grade, birthday);

	}

	@Override
	public Page<Student> queryStudentWithPage(String studentName, int sex, int currentPage, int pageSize) {
		List<Student> students = studentDao.queryStudentTotalRecord(studentName, sex);
		int totalRecord = students.size();
		Page<Student> page = new Page<Student>(currentPage, pageSize, totalRecord);
		int startIndex = page.getStartIndex();
		page.setList(studentDao.queryStudent(studentName, sex, startIndex, pageSize));
		return page;
	}

}
