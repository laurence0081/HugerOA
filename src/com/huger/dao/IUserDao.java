package com.huger.dao;

import com.huger.pojo.User;

public interface IUserDao {

    int insert(User user);
    
	int deleteById(Integer id);

    int update(User user);
    
    int updateJobtitle(int id, String jobtitle);
    
    int updatePWD(int id, String password);
    
    int updateImg(int id, String imgURL);
    
    User selectById(Integer id);
    
    User selectByCellphone(String cellphone);
    
    User selectByUserPWD(String cellphone, String password);
    
    String selectImgById(int id);
}
