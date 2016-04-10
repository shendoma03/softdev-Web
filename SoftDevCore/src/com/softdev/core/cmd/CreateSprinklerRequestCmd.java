package com.softdev.core.cmd;

import com.softdev.core.bean.SprinklerRequest;
import com.softdev.core.dao.SprinklerRequestDAO;
import com.softdev.core.exception.SoftDevException;

public class CreateSprinklerRequestCmd extends BaseCmd {

	/* input parameters */
	private Boolean operation;
	private String createUser;
	
	/* output param */

	
	@Override
	public void performValidation() throws SoftDevException {
		if (operation == null) {
			throw new SoftDevException("Username is required.");
		}
		if (createUser == null || createUser.equals("")) {
			throw new SoftDevException("Create user is required.");
		}
	}

	@Override
	public void performExecute() {
		SprinklerRequestDAO dao = new SprinklerRequestDAO();
		SprinklerRequest request = new SprinklerRequest();
		request.setCreateUser(createUser);
		request.setOperation(operation);
		request.setStatus("NEW");
		dao.create(request);
	}

	public void setOperation(Boolean operation) {
		this.operation = operation;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
}
