package com.andy.controller;



import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	private static Logger loger=Logger.getLogger(UserController.class);
     
	@RequestMapping(value = "/single")
	public String getSingleUser(@RequestParam int userid) {
		Map<String,Object>map=userService.getSingleUser(userid);
		 loger.info("运行到这里了"+map.toString());
		return map.toString();
	}
	@RequestMapping("/delete")
	public int deleteUser(@RequestParam int userid){
		return userService.deleteUser(userid);
	}
}
