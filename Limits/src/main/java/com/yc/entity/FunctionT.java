package com.yc.entity;

import java.io.Serializable;
import java.util.List;

public class FunctionT implements Serializable{

	
	private static final long serialVersionUID = 5833521730394013061L;
	private int fid;
	private String fname;
	private List<FunctionT> children;
	
	
	public int getFid() {
		return fid;
	}
	public int getId() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public String getText() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public List<FunctionT> getChildrens() {
		return children;
	}
	public void setChildrens(List<FunctionT> childrens) {
		this.children = childrens;
	}
	@Override
	public String toString() {
		return "FunctionT [fid=" + fid + ", fname=" + fname + ", childrens="
				+ children + "]";
	}
	
	
}
