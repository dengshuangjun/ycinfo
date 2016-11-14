package com.yc.model.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.entity.Profile;
import com.yc.service.ProfileService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ProfileServiceImplTest {
	
	@Autowired
	private ProfileService profileService;

	@Test
	public void Logintest() {
		Profile profile=new Profile();
		profile.setId(10003);
		profile.setName("oyinyah");
		System.out.println("qian"+profile);
		profile=profileService.login(profile);
		System.out.println(profile);
		assertNotNull(profile);
	}

}
