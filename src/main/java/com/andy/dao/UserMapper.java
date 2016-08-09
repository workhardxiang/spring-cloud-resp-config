package com.andy.dao;


import java.util.Map;


public interface UserMapper {
    Map<String, Object> getSingleUser(int userid); 
    int deleteUser(int userid);
}
