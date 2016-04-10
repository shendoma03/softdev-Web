package com.softdev.core.cmd;

import com.softdev.core.bean.SprinklerRequest;
import com.softdev.core.dao.SprinklerRequestDAO;
import com.softdev.core.exception.SoftDevException;

public class GetLatestPendingSprinklerRequestCmd extends BaseCmd {

	/* input parameters */

	/* output param */
	SprinklerRequest request;
	
	@Override
	public void performValidation() throws SoftDevException {
	}

	@Override
	public void performExecute() {
		SprinklerRequestDAO dao = new SprinklerRequestDAO();
		request = dao.getPendingSprinklerRequest();
	}

	public SprinklerRequest getPendingRequest() {
		return request;
	}
}
