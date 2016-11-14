package com.yc.entity;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class Profile implements Serializable{
	private static final long serialVersionUID = -2328730024229978788L;
	
	private MultipartFile imageFile;  //用于存放图片，springmvc框架中有
	
	private int id;
	private String name;
	private String birthday;
	private String gender;
	private String career;
	private String address;
	private String mobile;
	private String picPath;
	
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	
	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", birthday="
				+ birthday + ", gender=" + gender + ", career=" + career
				+ ", address=" + address + ", mobile=" + mobile + ", picPath="
				+ picPath + "]";
	}
	
	
	

	

}
