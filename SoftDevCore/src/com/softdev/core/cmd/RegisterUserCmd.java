package com.softdev.core.cmd;

import com.softdev.core.bean.User;
import com.softdev.core.dao.UserDAO;
import com.softdev.core.exception.SoftDevException;

public class RegisterUserCmd extends BaseCmd  {
	
	/* input parameters */
	private String userName;
	private String password;
	private String fname;
	private String lname;
	
	/* output param */

	private boolean isRegistered = false;
	
	@Override
	public void performValidation() throws SoftDevException {
		if (userName == null || userName.equals("")) {
			throw new SoftDevException("Username is required.");
		}
		if (password == null || password.equals("")) {
			throw new SoftDevException("Password is required.");
		}
		if (fname == null || fname.equals("")) {
			throw new SoftDevException("Username is required.");
		}
		if (lname == null || lname.equals("")) {
			throw new SoftDevException("Create user is required.");
		}
	}

	@Override
	public void performExecute() {
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setUsername(userName);
		user.setPassword(password);;
		user.setFname(fname);
		user.setLname(lname);
		dao.addUser(user);
		isRegistered = true;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setFName(String fname) {
		this.fname = fname;
	}

	public void setLName(String lname) {
		this.lname = lname;
	}

	public boolean isValidLogin() {
		return isRegistered;
	}

}
