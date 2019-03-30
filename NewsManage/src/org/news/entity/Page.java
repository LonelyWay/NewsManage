package org.news.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 分页类
 * @author WXL
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class Page<T> implements Serializable{
	private int currnPageNo;//当前页
	private int totalCount;//总数据条数
	private int pageSize;//分页大小
	private int totalPage;//总页数
	private  List<T> dataList;//数据集合
	/**
	 * 获取当前页码
	 * @return	int
	 */
	public int getCurrnPageNo() {
		return currnPageNo;
	}
	/**
	 * 设置当前页码
	 * @param currnPageNo	当前页码
	 */
	public void setCurrnPageNo(int currnPageNo) {
		this.currnPageNo = currnPageNo;
	}
	/**
	 * 获取总数据条数
	 * @return	int
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * 设置总数据条数
	 * @param totalCount	总页数
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 获取分页大小
	 * @return int
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * 设置分页大小
	 * @param pageCount	分页大小
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 获取总页数
	 * @return	int
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * 设置总页数
	 * @param totalPage	总页数
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * 获取数据集合
	 * @return	List<T>
	 */
	public List<T> getDataList() {
		return dataList;
	}
	/**
	 * 设置数据集合
	 * @param dataList	数据集合
	 */
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
}
