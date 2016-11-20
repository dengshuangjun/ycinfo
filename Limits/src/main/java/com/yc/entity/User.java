package com.yc.entity;


import java.io.Serializable;

/**
 * Created by dello on 2016/7/27.
 */
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7022019403547512027L;
	
	private int uid;
    private String uname;
    private String upwd;
    private String registertime;
    private String updatetime;
    
	public int getUid() {
		return uid;
	}
	public int getUids() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		if(upwd==null){
			return "";
		}
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}
	public String getUpdatetime() {
		if(updatetime==null){
			return "未修改过";
		}
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd
				+ ", registertime=" + registertime + ", updatetime="
				+ updatetime + "]";
	}
    
}
