package com.huger.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huger.dao.IUserDao;
import com.huger.pojo.User;
import com.huger.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;
	
	public int addUser(User user){
		return userDao.insert(user);
	}
    
	public int removeUserByID(Integer id){
		return userDao.deleteById(id);
	}

	public int modifyUser(User user){
		return userDao.update(user);
	}
    
	public int modifyJobtitle(int id, String jobtitle){
		return userDao.updateJobtitle(id, jobtitle);
	}
    
	public int modifyPWD(int id, String password){
		return userDao.updatePWD(id, password);
	}
    
	public int modifyImg(int id, String imgURL){
		return userDao.updateImg(id, imgURL);
	}

	public User getUserById(Integer id){
		return userDao.selectById(id);
	}
    
	public User getUserByCellphone(String cellphone){
		return userDao.selectByCellphone(cellphone);
	}
    
	public User getUserByUserPWD(String cellphone, String password){
		return userDao.selectByUserPWD(cellphone, password);
	}
    
	public String getUserImgById(int id){
		return userDao.selectImgById(id);
	}
}
