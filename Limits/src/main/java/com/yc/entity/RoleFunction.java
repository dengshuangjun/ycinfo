package com.yc.entity;


import java.io.Serializable;

/**
 * Created by dello on 2016/7/27.
 */
public class RoleFunction implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6331073813620528316L;
	
	private int id;
    private int role_id;
    private int function_id;
    private int status;
    
	
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
	public int getFunction_id() {
		return function_id;
	}
	public void setFunction_id(int function_id) {
		this.function_id = function_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "RoleFunction [id=" +id + ", role_id=" + role_id
				+ ", function_id=" + function_id + ", status=" + status + "]";
	}

}
