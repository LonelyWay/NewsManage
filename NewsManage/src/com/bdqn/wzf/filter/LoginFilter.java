package com.bdqn.wzf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.获取ssession
	HttpServletRequest req=(HttpServletRequest)request;	
	
	HttpSession session=req.getSession();
	String username=(String)session.getAttribute("username");
	if(username==null) {
		HttpServletResponse resp=(HttpServletResponse)response;
		resp.sendRedirect("login.html");	
	}else {
		chain.doFilter(request, response);
	}


}
}