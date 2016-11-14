package com.yc.mapper;

import com.yc.entity.Profile;
import com.yc.entity.ProfilePage;

public interface ProfileMapper {

	Profile getProfileByprofile(Profile profile);

	ProfilePage getData(ProfilePage profilePage);

	int updataProfile(Profile profile);

	Profile getProfile(Integer id);

	int deleteprofile(Integer id);

}