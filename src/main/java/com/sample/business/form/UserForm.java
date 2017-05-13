package com.sample.business.form;

import javax.validation.Valid;

import com.sample.business.model.User;

/**
 * フォーム(HTML用のパラメタを受け取れるように作っておいた方がよいと思います)
 * 
 * @author zac
 * 
 */
public class UserForm {
	@Valid
	public User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
