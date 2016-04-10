package com.softdev.core.cmd;

import com.softdev.core.bean.FarmStatus;
import com.softdev.core.dao.FarmStatusDAO;
import com.softdev.core.exception.SoftDevException;

public class GetLatestFarmStatusCmd extends BaseCmd{
		/* input parameters */

		/* output param */
		FarmStatus request;
		
		@Override
		public void performValidation() throws SoftDevException {
		}

		@Override
		public void performExecute() {
			FarmStatusDAO dao = new FarmStatusDAO();
			request = dao.getLatestStatus();
		}

		public FarmStatus getLatestStatus() {
			return request;
		}
}
