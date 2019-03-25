package com.bdqn.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.news.entity.User;
/**
 * 实现对用户的增删改查
 * @author ASUS
 *
 */
public class UserDao extends BaseDao{
	private static BaseDao bd = new BaseDao();
	private static int count = 0;
	private static String sql = null;
	/**
	 * 查询所有用户
	 * @param start	起始条数
	 * @param pageSize	每页页大小
	 * @return
	 */
	public static  List<User> selectAllUser(int start,int pageSize) {
		User user = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		if(start<0) {
			sql = "SELECT * FROM news_users;";
			rs = bd.executeQuery(sql);
		}else {
			sql = "SELECT * FROM news_users LIMIT ?,?;";
			rs = bd.executeQuery(sql, start,pageSize);
		}
		try {
			while(rs.next()) {
				user = new User();
				user.setUid(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setUpwd(rs.getString(3));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	/**
	 * 添加用户
	 * @param uName	用户名
	 * @param uPwd	密码
	 * @return	int
	 */
	public static int addUser(String uName,String uPwd) {
		count = 0;
		sql = "INSERT INTO news_users (uname,upwd) VALUES(?,?);";
		count = bd.executeUpdate(sql, uName,uPwd);
		 return	count;
	}
	/**
	 * 
	 * @param uId	用户id
	 * @return	int
	 */
	public static int delUser(int uId) {
		count = 0;
		sql = "DELETE FROM news_users WHERE uid=?;";
		count = bd.executeUpdate(sql,uId);
		return count;
	}
	/**
	 * 根据用户id修改用户名或密码
	 * @param uName	用户名
	 * @param uPwd	密码
	 * @param uId	用户id
	 * @return	int
	 */
	public static int updateUser(String uName,String uPwd,int uId) {
		count = 0;
		sql = "UPDATE news_users SET uname=?,upwd=? WHERE uid=?;";
		count = bd.executeUpdate(sql, uName,uPwd,uId);
		return count;
		
	}
	
}
