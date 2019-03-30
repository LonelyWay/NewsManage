package com.bdqn.service;

import java.util.List;

import org.news.entity.Page;
import org.news.entity.User;

import com.bdqn.web.dao.UserDao;
/**
 * 分页
 * @author ASUS
 *
 */
public class PageService {
	/**
	 * 实现分页
	 * @param currnPageNo	当前页码
	 * @param limit			当前页大小
	 * @return
	 */
	public static Page<User> groupPage(int currnPageNo,int pageSize){
		int start = (currnPageNo-1)*pageSize;
		List<User> userList = UserDao.selectAllUser(start, pageSize);
		Page<User> userPage = new Page<User>();
		userPage.setCurrnPageNo(currnPageNo);
		userPage.setPageSize(pageSize);
		userPage.setDataList(userList);
		int totalCount = UserDao.selectAllUser(-1, pageSize).size();//总数据条数
		int totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;//总页数
		userPage.setTotalPage(totalPage);
		userPage.setTotalCount(totalCount);
		return userPage;
	}
}
