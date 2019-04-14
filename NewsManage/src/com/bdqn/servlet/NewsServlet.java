package com.bdqn.servlet;

import com.alibaba.fastjson.JSONObject;

import com.bdqn.service.NewsService;
import com.bdqn.zmj.util.Page;
import org.news.entity.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: ChaW
 * Date: 2019/3/27
 * Time: 13:02
 * Description: No Description
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        NewsService service = new NewsService();
        String opr = request.getParameter("opr");
        PrintWriter out = response.getWriter();
        if (opr.equals("add")){
            String title = request.getParameter("title");
            String date = request.getParameter("date");
            String tid = request.getParameter("tid");
            String content = request.getParameter("content");
            String author = request.getParameter("author");
            String summary = request.getParameter("summary");
            int count = service.add(Integer.parseInt(tid),title,date,content,author,summary);
            if (count > 0){
                out.write("ok");
            }else {
                out.write("error");
            }
        }

        Page<News> p;
        if (opr.equals("load")){
            String page = request.getParameter("page");
            String limit = request.getParameter("limit");
            p = service.list(Integer.parseInt(page),10);
            out.write(JSONObject.toJSONString(p));

//            if (page != null && !page.equals("")){
////                p = service.list(Integer.parseInt(page),Integer.parseInt(limit));
////                out.write(JSONObject.toJSONString(p));
//            }else{
//                p = service.list(1,10);
//                List<News> list = new ArrayList<News>();
//                list = p.getData();
//                out.write(JSONObject.toJSONString(list));
//            }


        }

        if (opr.equals("del")){
            String nid = request.getParameter("nid");
            int count = service.delete(Integer.parseInt(nid));
            if (count > 0){
                System.out.println(">0");
                out.write("success");
            }else {
                out.write("defeat");
            }
        }

        if (opr.equals("toupdate")){
            String nid = request.getParameter("nid");
            News news = service.selectByid(Integer.parseInt(nid));
//            out.write(JSONObject.toJSONString(news));
            request.setAttribute("news",news);
            request.getRequestDispatcher("static/newsupdate.jsp").forward(request,response);
        }

        if (opr.equals("update")){
            String title = request.getParameter("title");
            String nid = request.getParameter("nid");
            String tid = request.getParameter("tid");
            String content = request.getParameter("content");
            String author = request.getParameter("author");
            String summary = request.getParameter("summary");
            int count = service.update(Integer.parseInt(tid),title,author,content,summary,Integer.parseInt(nid));
            if (count > 0){
                out.write("ok");
            }else {
                out.write("error");
            }
        }
    }
}
