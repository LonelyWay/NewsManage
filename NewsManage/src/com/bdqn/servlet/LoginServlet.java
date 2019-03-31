package com.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.wzf.listener.SessionBindingListener;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//获取登录的表单数据
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		if(username!=null&&password!=null) {
			
			//假装输对了，我们直接创建session;
			
			HttpSession session=req.getSession();
			
			session.setAttribute("username", username);
			//绑定SESSION，让监听器生效；
			session.setAttribute("listener", new SessionBindingListener());
			out.print("<script>alert('登陆成功');location.href='topic.jsp'</script>");
		}else {
			out.print("<script>alert('登陆失败');location.href='login.jsp'</script>");
		}
		
	
	}

}
