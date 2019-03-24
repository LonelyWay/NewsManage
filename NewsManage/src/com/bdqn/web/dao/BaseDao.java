package com.bdqn.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bdqn.zmj.util.Dbutil;

public class BaseDao {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement ppst;

	//增删改
	public int executeUpdate(String sql,Object...objects) {
		try {
			ppst = Dbutil.getConn().prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ppst.setObject(i+1, objects[i]);
			}
			int flag = ppst.executeUpdate();
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return -1;	
	}
	/**
	 * 根据条件查询数据
	 * @param sql	
	 * @param objects
	 * @return	ResultSet
	 */
	public ResultSet executeQuery(String sql,Object...objects) {
		try {
			ppst = Dbutil.getConn().prepareStatement(sql);
			if (objects.length>0) {
				for (int i = 0; i < objects.length; i++) {
					ppst.setObject(i+1, objects[i]);
				}
			}
			rs = ppst.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return null;	
	}
}
