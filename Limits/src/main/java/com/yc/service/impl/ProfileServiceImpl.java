package com.yc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.mapper.ProfileMapper;
import com.yc.service.ProfileService;
import com.yc.entity.Profile;
import com.yc.entity.ProfilePage;
@Service("profileService")
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileMapper profileMapper;

	public Profile login(Profile profile) {
		return profileMapper.getProfileByprofile(profile);
	}

	@Override
	public ProfilePage getData(ProfilePage profilePage) {
		return profileMapper.getData(profilePage);
	}

	@Override
	public int updataProfile(Profile profile) {
		return profileMapper.updataProfile(profile);
	}

	@Override
	public Profile getProfile(Integer id) {
		return profileMapper.getProfile(id);
	}

	@Override
	public int deleteprofile(Integer id) {
		return profileMapper.deleteprofile(id);
	}


}
