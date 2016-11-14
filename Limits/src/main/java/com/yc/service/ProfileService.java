package com.yc.service;

import com.yc.entity.Profile;
import com.yc.entity.ProfilePage;

public interface ProfileService {

	Profile login(Profile profile);

	ProfilePage getData(ProfilePage profilePage);

	int updataProfile(Profile profile);

	Profile getProfile(Integer id);

	int deleteprofile(Integer id);


}
