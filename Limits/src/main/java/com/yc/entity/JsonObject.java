package com.yc.entity;

import java.util.List;

public class JsonObject<T> {
	private List<T> rows;
	private int total;
	private T object;
	
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	@Override
	public String toString() {
		return "JsonObject [rows=" + rows + ", total=" + total + ", object="
				+ object + "]";
	}
}
