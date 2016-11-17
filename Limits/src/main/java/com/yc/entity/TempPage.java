package com.yc.entity;

import java.util.List;

public class TempPage<T> {
	private int page;//页数
	private int rows;//条数
	private int total;//总跳四
	private List<T> contents;//要显示的数据
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getContents() {
		return contents;
	}
	public void setContents(List<T> contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "TempPage [page=" + page + ", rows=" + rows + ", total=" + total
				+ ", contents=" + contents + "]";
	}
}
