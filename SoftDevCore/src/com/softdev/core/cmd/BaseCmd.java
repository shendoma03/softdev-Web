package com.softdev.core.cmd;

import com.softdev.core.exception.SoftDevException;

public abstract class BaseCmd {

	public abstract void performValidation() throws SoftDevException;
	public abstract void performExecute();
	
	public void execute() throws SoftDevException {
		performValidation();
		performExecute();
	}
	
}
