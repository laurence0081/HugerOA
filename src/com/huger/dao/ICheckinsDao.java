package com.huger.dao;

import com.huger.pojo.Checkins;

public interface ICheckinsDao {

    int insert(Checkins user);
    
	int deleteById(Integer id);

    int update(Checkins user);
    
    int updateImg(int id, String imgURL);
    
    User selectByType(Integer type);
    
    User selectByUserId(String cellphone);
    
    User selectByUserPWD(String cellphone, String password);
    
    String selectImgById(int id);
}
