package com.andy.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.andy.dao.UserMapper;

@Service
public class UserService {
     @Autowired
     private UserMapper userMapper;
     @Cacheable("xiang")
     public Map<String, Object> getSingleUser(int userid){
    	 System.out.println("这是查询数据库得到的");
    	 return userMapper.getSingleUser(userid);
     }
     @CacheEvict("xiang")
     public int deleteUser(int userid){
    	 System.out.println("删除了用户");
    	 return userMapper.deleteUser(userid);
     }
}
