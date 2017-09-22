package com.shsxt.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shsxt.entity.User;
import com.shsxt.service.UserService;
import com.shsxt.service.impl.UserServiceImpl;
import com.shsxt.util.StringUtil;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	// 请求的分发
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("option");
		if (StringUtil.isEmpty(option)) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		if ("login".equals(option)) {
			login(request, response);
		}
		if ("logout".equals(option)) {
			logout(request, response);
		}
		if ("register".equals(option)) {
			register(request, response);
		}

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		Cookie[] cookie = request.getCookies();
		if (cookie != null) {
			for (Cookie c : cookie) {
				if ("user".equals(c.getName())) {
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
		response.sendRedirect("login.jsp");
		return;
	}

	private void register(HttpServletRequest request, HttpServletResponse response) {

	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String remember = request.getParameter("remember");

		if (!StringUtil.isEmpty(uname) && !StringUtil.isEmpty(pwd)) {

			User user = userService.queryUserByUnameAndPwd(uname, pwd);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				if (StringUtil.isEmpty(remember)) {
					Cookie cookie = new Cookie("user", user.getUname() + "=" + user.getPwd());
					cookie.setMaxAge(60 * 60 * 24 * 3);
					response.addCookie(cookie);
				}
				request.getRequestDispatcher("student").forward(request, response);
			} else {
				request.setAttribute("msg", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			// 用户名或者密码为空的时候， 跳转回登录页面
			// 无用的多余的操作

			request.setAttribute("msg", "请确认同户名和密码 ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
