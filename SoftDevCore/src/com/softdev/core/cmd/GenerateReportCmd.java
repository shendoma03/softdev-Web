package com.softdev.core.cmd;

import java.util.List;

import com.softdev.core.bean.FarmStatus;
import com.softdev.core.dao.FarmStatusDAO;
import com.softdev.core.exception.SoftDevException;

public class GenerateReportCmd extends BaseCmd {

	/* input parameters */
	private String month;

	/* output param */
	List<FarmStatus> farmStatuses;

	@Override
	public void performValidation() throws SoftDevException {
		if (month == null) {
			throw new SoftDevException("Month is required.");
		}
	}

	@Override
	public void performExecute() {
		FarmStatusDAO dao = new FarmStatusDAO();
		farmStatuses = dao.getMonthlyReport(month);
	}

	public List<FarmStatus> getFarmStatuses() {
		return farmStatuses;
	}

	public void setMonth(String month) {
		this.month = month;
	}
}
