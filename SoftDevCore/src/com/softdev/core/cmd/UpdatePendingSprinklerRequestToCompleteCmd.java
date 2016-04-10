package com.softdev.core.cmd;

import com.softdev.core.bean.SprinklerRequest;
import com.softdev.core.dao.SprinklerRequestDAO;
import com.softdev.core.exception.SoftDevException;

public class UpdatePendingSprinklerRequestToCompleteCmd extends BaseCmd {

	/* input parameters */
	private Integer requestId;

	/* output param */
	SprinklerRequest request;
	
	@Override
	public void performValidation() throws SoftDevException {
		if (requestId == null) {
			throw new SoftDevException("Request ID is required.");
		}
	}

	@Override
	public void performExecute() {
		SprinklerRequestDAO dao = new SprinklerRequestDAO();
		dao.updatePendingRequest("COMPLETE", null, "SYSTEM", requestId);
	}

	public SprinklerRequest getPendingRequest() {
		return request;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
}
