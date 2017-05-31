package com.zac.business.service;
import org.springframework.stereotype.Component;

import com.zac.business.model.User;
import com.zac.dao.UserDao;


//本当はインターフェースからimplemetsすべきですが、ここでは簡略のためそのままクラスを作っています。
@Component(value="userService")
public class UserService {
	private UserDao userDao;
	
	public UserDao getUserDao() {
	return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User getUser(String id){
		return this.userDao.getUser(id);
	}
	
	public void updateUser(User user){
		this.userDao.updateUser(user);
	}
}