package com.yc.model.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.yc.entity.User;
import com.yc.utils.DBHelper;

public class MysqlTest {
	@Test
	public void test(){
		DBHelper db= new DBHelper();
		String sql="select uid,upwd,uname from auth_user where uname=? and upwd=?";
		List<Object> params = new ArrayList<Object>();
		params.add("a");
		params.add("a");
		Date date=new Date();
		System.out.println(date.getTime());
		System.out.println(db.select(sql, params));
		date=new Date();
		System.out.println(date.getTime());
	}
}
