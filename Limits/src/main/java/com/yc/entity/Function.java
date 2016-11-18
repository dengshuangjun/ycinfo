package com.yc.entity;

import java.io.Serializable;


public class Function implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8889995540070510045L;
	
	private int fid;
	private String fname;
	private int parent_id;
	private String url;
	private Integer serialNum;
	private Integer accordion;
	
	public int getFid() {
		return fid;
	}
	public int getid() {
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
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}
	public Integer getAccordion() {
		return accordion;
	}
	public void setAccordion(Integer accordion) {
		this.accordion = accordion;
	}
	@Override
	public String toString() {
		return "Function [fid=" + fid + ", fname=" + fname + ", parent_id="
				+ parent_id + ", url=" + url + ", serialNum=" + serialNum
				+ ", accordion=" + accordion + "]";
	}
}
