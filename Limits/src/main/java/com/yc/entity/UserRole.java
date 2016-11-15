package com.yc.entity;


import java.io.Serializable;

/**
 * Created by dello on 2016/7/27.
 */
public class UserRole implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5416250590895611165L;
	private int id;
    private int role_id;
    private int user_id;
    
	public int getId() {
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
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", role_id=" + role_id + ", user_id="
				+ user_id + "]";
	}
}