package com.shsxt.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if ("update".equals(act)) {
			update(request, response);
		}
		if ("delete".equals(act)) {
			delect(request, response);
		}

	}

	private void delect(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
