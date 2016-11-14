package com.yc.handler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.yc.entity.Profile;
import com.yc.entity.ProfilePage;
import com.yc.service.ProfileService;
import com.yc.utils.SessionAttributeKey;


@Controller
@RequestMapping("/front")
@SessionAttributes("profile")
public class ProfileHandler {
	@Autowired
	private ProfileService profileService;
	
	/** 
     * 用于存放账号和session对应关系的map 
     */  
   // private Map<String, HttpSession> sess = new HashMap<String, HttpSession>();  
	
	/**
	 * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用! 
	 * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
	 * 1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
	 * 2). SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中. 
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id, 
			Map<String, Object> map){
		System.out.println("modelAttribute method");
		if(id != null){
			//模拟从数据库中获取对象
			Profile profile=profileService.getProfile(id);
			if(profile!=null){
				System.out.println("从数据库中获取一个对象: " + profile);
				map.put("profile", profile);
			}else{
				map.put(SessionAttributeKey.ERROR_MSG, "用户不存在");
			}
		}
	}
	
	/*
	 * RequestMapping：这个是用来进行地址映射的，通过他才可以找到用什么方法处理请求
	 * value：     指定请求的实际地址，指定的地址可以是URI Template 模式（后面将会说明）；
	 * method：  指定请求的method类型， GET、POST、PUT、DELETE等；
	*/
	
	//登入
	@RequestMapping(value = "/login")
	public String loginSuccess(Profile profile, ModelMap map) {
		//System.out.println(profile);
		profile = profileService.login(profile);
		if (profile == null) {
			map.put(SessionAttributeKey.ERROR_MSG, "用户名会密码错误");
			return "index";
		} else {
			map.addAttribute(SessionAttributeKey.LOGIN_USER,profile);
			return "page/list";
		}

	}
	
	//登入成功获取数据
	@ResponseBody
	@RequestMapping(value = "/getData",method=RequestMethod.POST)
	public Map<String, Object> getData(ProfilePage profilePage) {
		Map<String, Object> map = new HashMap<String, Object>();
		profilePage = profileService.getData(profilePage);
		//System.out.println(profilePage);
		if (profilePage != null) {
			map.put("total", profilePage.getTotal());
			map.put("rows", profilePage.getProfiles());
		} else {
			map.put("total", 0);
			map.put("rows", new ArrayList<Profile>());
		}
		return map;
	}
	
	//更新数据
	@ResponseBody
	@RequestMapping(value= "/updata",method=RequestMethod.POST)
	public int updata(Profile profile) {
		System.out.println("要修改的profile"+profile);
		MultipartFile imageFile=profile.getImageFile();
		int result;
		if(!imageFile.isEmpty()){
			String picName=imageFile.getOriginalFilename();
			//注值
			profile.setPicPath(picName);
			//修改
			System.out.println(profile);
			String paths=System.getProperty("evan.webapp");
			paths=paths.substring(0,paths.lastIndexOf("\\"));
			String realpath=paths.substring(0,paths.lastIndexOf("\\"))+"\\uploadpic";
			try {
				FileUtils.copyInputStreamToFile(imageFile.getInputStream(), new File(realpath,picName));
				System.out.println("上传成功");
				//修改用户信息
				result=profileService.updataProfile(profile);
				return  result;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("上传失败");
				return 0;
			}
		}else{
			result=profileService.updataProfile(profile);
			return result;
		}
	}
	
	//删除数据
	@ResponseBody
	@RequestMapping(value = "/remove",method=RequestMethod.POST)
	public int remove(int id){
		System.out.println("要删除的id"+id);
		int result=profileService.deleteprofile(id);
		return result;
	}

}
