package com.yc.entity;

import java.util.List;

public class ProfilePage {
	private int page;//页数
	private int rows;//条数
	private int total;//总跳四
	private List<Profile> Profiles;//要显示的数据
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
	public List<Profile> getProfiles() {
		return Profiles;
	}
	public void setProfiles(List<Profile> profiles) {
		Profiles = profiles;
	}
	@Override
	public String toString() {
		return "ProfilePage [page=" + page + ", rows=" + rows + ", total="
				+ total + ", Profiles=" + Profiles + "]";
	}
	
	
}
