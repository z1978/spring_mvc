package com.sample.dao;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sample.business.model.User;

 

//本当はインターフェースからimplemetsすべきですが、ここでは簡略のためそのままクラスを作っています。
public class UserDao {
	public User getUser(String id){
		//ここではハードコードしていますが、本当はDBから値を取得します。
		User user = new User();
		try {
			user.setId(id);
			user.setName("未華子");
			user.setAge(21);
			SimpleDateFormat f =new SimpleDateFormat("yyyy/MM/dd");
			user.setUpDate(f.parse("2012/04/01"));
		} catch (ParseException e) {}
		return user;
	}
	    
	public void updateUser(User user){
		//DBに値を更新する処理を書きます。ここでは省略。
	}

}