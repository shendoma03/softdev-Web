package com.softdev.core.cmd;

import com.softdev.core.bean.User;
import com.softdev.core.dao.UserDAO;
import com.softdev.core.exception.SoftDevException;

public class GetUserByUserNameCmd extends BaseCmd{
	/* input parameters */
	private String userName;
	
	/* output param */
	private User user;

	@Override
	public void performValidation() throws SoftDevException {
		if (userName == null || userName.equals("")) {
			throw new SoftDevException("Username is required.");
		}
	}

	@Override
	public void performExecute() {
		UserDAO dao = new UserDAO();
		user = dao.getByUserName(userName);
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getUser() {
		return user;
	}
}
