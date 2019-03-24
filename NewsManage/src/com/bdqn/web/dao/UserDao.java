package com.bdqn.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.news.entity.User;

public class UserDao extends BaseDao{
	/**
	 * 查询所有用户
	 * @param start	起始条数
	 * @param pageSize	每页页大小
	 * @return
	 */
	public static  List<User> selectAllUser(int start,int pageSize) {
		BaseDao bd = new BaseDao();
		User user = null;
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM news_users LIMIT ?,?;";
		ResultSet rs = bd.executeQuery(sql, start,pageSize);
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
	public static void main(String[] args) {
		List<User> userList = selectAllUser(5, 5);
		for (User user : userList) {
			System.out.println(user.getUid()+"\t"+user.getUname()+"\t"+user.getUpwd());
		}
	}
}
