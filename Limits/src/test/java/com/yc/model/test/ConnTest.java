package com.yc.model.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.service.Functionservice;
import com.yc.service.Roleservice;
import com.yc.service.Userservice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ConnTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private Userservice userservice;
	
	@Autowired
	private Roleservice roleservice;
	
	@Autowired
	private Functionservice functionservice;
	
	@Test
	public void testConn() {
		Connection con=null;
		try {
			con=dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertNotNull(con);
	}
	
	@Test
	public void testConn02() {
		Connection con=null;
		try {
			con=sqlSessionFactory.openSession().getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(con);
	}
	
	@Test
	public void TestRoles(){
		System.out.println(roleservice.findRolesById(1));
	}
	
	@Test
	public void TestFunctions(){
		System.out.println(functionservice.findFunctionsById("安全权限",2));
	}
	
	@Test
	public void TestFindPages(){
		System.out.println(userservice.findPage(0, 10));
	}

}
