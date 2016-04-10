package com.softdev.core.cmd;

import com.softdev.core.bean.User;
import com.softdev.core.dao.UserDAO;
import com.softdev.core.exception.SoftDevException;

public class ValidateLoginCmd extends BaseCmd {

	/* input parameters */
	private String userName;
	private String password;
	
	/* output param */

	private boolean isValidLogin = false;
	
	@Override
	public void performValidation() throws SoftDevException {
		if (userName == null || userName.equals("")) {
			throw new SoftDevException("Username is required.");
		}
		if (password == null || password.equals("")) {
			throw new SoftDevException("Password is required.");
		}
	}

	@Override
	public void performExecute() {
		UserDAO dao = new UserDAO();
		User user = dao.getByUserName(userName);
		if (user == null) {
			isValidLogin = false;
		} else if (user.getUsername().equals(userName) && (user.getPassword().equals(password))) {
			isValidLogin = true;	
		} else {
			isValidLogin = false;
		}
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValidLogin() {
		return isValidLogin;
	}
}
