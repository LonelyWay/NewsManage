package com.bdqn.wzf.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bdqn.zmj.dao.TopicDao;
import com.bdqn.zmj.entity.Topic;


/*
 * 由于主题一般不会变化，所以我们在容器启动的时侯将所有主题查询
 * 出来，保存在上下文对象中，后续可以直接从上下文对象中获取，
 * 减少数据访问次数
 */
@WebListener
public class ContextLoadListener implements ServletContextListener{
	//上下文对象创建成功后执行的方法（Tomcat启动的时侯会自动调用该方法）
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		 //判断application上下文对象中有没有数据
	    TopicDao dao=new TopicDao();
		List<Topic> topics=dao.select();
		//将topic添加到application
		sce.getServletContext().setAttribute("topics", topics);
		System.out.println("所有主题已添加完毕。。。。。。。");
	}


}
