package com.softdev.core.exception;

@SuppressWarnings("serial")
public class SoftDevException extends Exception {
	
	public SoftDevException(Exception e) {
		super(e);
	}
	
	public SoftDevException(String msg, Exception e) {
		super(msg, e);
	}
	
	public SoftDevException(String msg) {
		super(msg);
	}
}
