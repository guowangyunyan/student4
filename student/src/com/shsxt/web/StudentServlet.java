package com.shsxt.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shsxt.entity.Page;
import com.shsxt.entity.Student;
import com.shsxt.service.StudentService;
import com.shsxt.service.impl.StudentServiceImpl;
import com.shsxt.util.StringUtil;

public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentService studentService;

	@Override
	public void init() throws ServletException {
		studentService = new StudentServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		if (StringUtil.isEmpty(act)) {
			show(request, response);
		}
		if ("add".equals(act)) {
			add(request, response);
		}
		if ("showStu".equals(act)) {
			showStu(request, response);
		}
		if ("update".equals(act)) {
			update(request, response);
		}
		if ("delete".equals(act)) {
			delect(request, response);
		}
		if ("query".equals(act)) {
			query(request, response);
		}

	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentName = request.getParameter("studentName");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String currentPageStr = request.getParameter("currentPage");
		String pageSizeStr = request.getParameter("pageSize");

		if (StringUtil.isEmpty(currentPageStr)) {
			currentPageStr = "1";
		}
		if (StringUtil.isEmpty(pageSizeStr)) {
			pageSizeStr = "2";
		}
		int currentPage = Integer.parseInt(currentPageStr);
		int pageSize = Integer.parseInt(pageSizeStr);
		Page<Student> page = studentService.queryStudentWithPage(studentName, sex, currentPage, pageSize);
		request.setAttribute("page", page);
		request.getRequestDispatcher("main.jsp").forward(request, response);

	}

	private void delect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentIdStr = request.getParameter("studentId");
		studentService.deleteStudentByStudentId(studentIdStr);
		request.getRequestDispatcher("student?act=").forward(request, response);
	}

	private void showStu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentIdStr = request.getParameter("studentId");
		Student student = studentService.queryStudentByStudentId(studentIdStr);
		request.setAttribute("student", student);
		request.getRequestDispatcher("edit.jsp").forward(request, response);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentIdStr = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		String grade = request.getParameter("grade");
		String ageStr = request.getParameter("age");
		String sexStr = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		studentService.updateStudentByStudentId(studentIdStr, studentName, grade, ageStr, sexStr, birthday);
		request.getRequestDispatcher("student?act=").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentName = request.getParameter("name");
		String ageStr = request.getParameter("age");
		String grade = request.getParameter("grade");
		String sexStr = request.getParameter("sex");
		String birthday = request.getParameter("birthday").trim();
		studentService.add(studentName, ageStr, grade, sexStr, birthday);
		request.getRequestDispatcher("student?act=").forward(request, response);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPageStr = request.getParameter("currentPage");
		String pageSizeStr = request.getParameter("pageSize");
		if (StringUtil.isEmpty(currentPageStr)) {
			currentPageStr = "1";
		}
		if (StringUtil.isEmpty(pageSizeStr)) {
			pageSizeStr = "5";
		}
		int currentPage = Integer.parseInt(currentPageStr);
		int pageSize = Integer.parseInt(pageSizeStr);
		Page<Student> page = studentService.queryAllStudentWithPage(currentPage, pageSize);

		request.setAttribute("page", page);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
