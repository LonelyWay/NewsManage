package com.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.news.entity.Page;
import org.news.entity.User;

import com.alibaba.fastjson.JSONObject;
import com.bdqn.service.PageService;

@SuppressWarnings("serial")
@WebServlet("/UserEditorServlet")
public class UserEditorServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=utf-8"); 
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String currnPageNo = req.getParameter("page");
		String pageSize = req.getParameter("limit");
		System.out.println(currnPageNo+"**"+pageSize);
		Page<User> p = PageService.groupPage(Integer.parseInt(currnPageNo), Integer.parseInt(pageSize));
		PrintWriter out = resp.getWriter();
		out.write(JSONObject.toJSONString(p));
	}
}
