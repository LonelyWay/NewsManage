package com.bdqn.wzf.filter;

import java.io.IOException;

import javax.security.auth.DestroyFailedException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	
	
	String encoding="";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("-----EncodingFilter初始化完毕------");
		encoding=filterConfig.getInitParameter("encoding");
		System.out.println("encoding编码为:"+encoding);
	}
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//所有请求进来，都将他的编码设置为UTF-8
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);//放过请求
		System.out.println("******退出过滤器EncodingFilter********");
		
		
	}

	//tomcat关闭的时侯销毁
    @Override
    public void destroy() {
    	System.out.println("----EncodingFilter销毁------");
    	
    }
	
}
