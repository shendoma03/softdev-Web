package com.softdev.core.cmd;

import com.softdev.core.bean.FarmStatus;
import com.softdev.core.dao.FarmStatusDAO;
import com.softdev.core.exception.SoftDevException;

public class CreateFarmStatusCmd extends BaseCmd{

	/* input parameters */
	private String smlvl;
	private Double analogSmlvl;
	private Double temp;
	private String waterlvl;
	
	
	/* output param */

	
	@Override
	public void performValidation() throws SoftDevException {
		if (smlvl == null || smlvl.equals("")) {
			throw new SoftDevException("Soil Moisture Level is required.");
		}
		if (analogSmlvl == null ) {
			throw new SoftDevException("Analog Soil Moisture Level is required.");
		}
		if (temp == null ) {
			throw new SoftDevException("Temperature is required.");
		}
		if (waterlvl == null || waterlvl.equals("")) {
			throw new SoftDevException("Water Level is required.");
		}
	}

	@Override
	public void performExecute() {
		FarmStatusDAO dao = new FarmStatusDAO();
		FarmStatus farmStatus = new FarmStatus();
		farmStatus.setSmlvl(smlvl);
		farmStatus.setAnalogSmlvl(analogSmlvl);
		farmStatus.setTemp(temp);
		farmStatus.setWlvl(waterlvl);
		dao.addStatus(farmStatus);
		
	}

	public void setSmlvl(String smlvl) {
		this.smlvl = smlvl;
	}

	public void setAnalogSmlvl(Double analogSmlvl) {
		this.analogSmlvl = analogSmlvl;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public void setWaterlvl(String waterlvl) {
		this.waterlvl = waterlvl;
	}


}
