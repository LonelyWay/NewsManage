package com.bdqn.wzf.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
/*
 * ���Ǹ�֪�ͺż�����������ͨ�ļ��������÷�����һ����
 * 
 * 
 */
public class SessionBindingListener implements HttpSessionBindingListener {
	
	String username;
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		username=(String)event.getSession().getAttribute("username");
		System.out.println(username+"������...");
	}
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(username+"������...");
    	
    }

}
