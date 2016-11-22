package com.yc.entity;

import java.io.Serializable;
import java.util.List;

public class FunctionTree implements Serializable {

	private static final long serialVersionUID = -4041911414004494063L;
	
	private int id;
	private String text;
	private Boolean checked;
	private List<FunctionTree> children;
	
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<FunctionTree> getChildren() {
		return children;
	}
	public void setChildren(List<FunctionTree> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "FunctionTree [id=" + id + ", text=" + text + ", children="
				+ children + "]";
	}
	
}
