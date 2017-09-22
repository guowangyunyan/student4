package com.shsxt.entity;

import java.util.List;

public class Page<T> {
	private Integer currentPage;// 当前页
	private Integer pageSize;// 页面展示数据条数
	private Integer totalPage;// 总页数
	private Integer totalRecord;// 总数据条数
	private Integer startIndex;// 开始索引

	private List<T> list;// 每页要显示的数据

	public Page() {
		super();
	}

	public Page(Integer currentPage, Integer pageSize, Integer totalRecord) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;

		// totalPage 总页数
		this.totalPage = (totalRecord + pageSize - 1) / pageSize;
		// 开始索引
		this.startIndex = (currentPage - 1) * pageSize;

	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
