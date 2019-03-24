package org.news.entity;

import java.io.Serializable;

/*
 * 用户 实体类
 * @author
 */
public class User implements Serializable {
	
    private static final long serialVersionUID = 435894070589975762L;
    private int uid;
	private String uname;
	private String upwd;
	/**
	 * 设置用户id
	 * @param uid	用户id
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * 设置用户名
	 * @param uname	用户名
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * 设置用户密码
	 * @param upwd	用户密码
	 */
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	/**
	 * 获取用户id
	 * @return	int
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * 获取用户名
	 * @return	String
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * 获取用户密码
	 * @return	String
	 */
	public String getUpwd() {
		return upwd;
	}
}
