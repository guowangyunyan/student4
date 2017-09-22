package com.shsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shsxt.entity.User;

public class UserFilter implements Filter {

	public UserFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		if (uri.contains("user") && "login".equals(req.getParameter("option"))
				|| uri.contains("user") && "logout".equals(req.getParameter("option")) || uri.contains("register")) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				chain.doFilter(req, resp);
			}

			String msg = "请先登录";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
