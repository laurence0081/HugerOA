package com.huger.service;

import com.huger.pojo.User;

public interface IUserService {

	public int addUser(User user);
    
	public int removeUserByID(Integer id);

	public int modifyUser(User user);
    
	public int modifyJobtitle(int id, String jobtitle);
    
	public int modifyPWD(int id, String password);
    
	public int modifyImg(int id, String imgURL);
    
	public User getUserById(Integer id);
    
	public User getUserByCellphone(String cellphone);
    
	public User getUserByUserPWD(String cellphone, String password);
    
	public String getUserImgById(int id);
}
