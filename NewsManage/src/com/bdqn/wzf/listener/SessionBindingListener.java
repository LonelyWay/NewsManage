package com.bdqn.wzf.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/*
 * 它是感知型号监听器，和普通的监听器配置方法不一样。
 * 
 * 
 */
public class SessionBindingListener implements HttpSessionBindingListener {
	
	String username;
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		username=(String)event.getSession().getAttribute("username");
		System.out.println(username+"上线了...");
	}
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(username+"下线了...");
    	
    }

}
