package com.yc.entity;


import java.io.Serializable;


public class UserRole implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5416250590895611165L;
	private int id;
    private int role_id;
    private int user_id;
    private String rname;
    private String uname;
    
	public int getId() {
		return id;
	}
	public int getIds() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", role_id=" + role_id + ", user_id="
				+ user_id + ", rname=" + rname + ", uname=" + uname + "]";
	}
}