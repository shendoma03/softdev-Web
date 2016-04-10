package com.softdev.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.softdev.core.bean.FarmStatus;
import com.softdev.core.cmd.CreateFarmStatusCmd;
import com.softdev.core.cmd.GetLatestFarmStatusCmd;
import com.softdev.core.exception.SoftDevException;

@Path("/scan")
public class SprinklerScannerController {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response scan(FarmStatus status) {
		try {
			CreateFarmStatusCmd cmd = new CreateFarmStatusCmd();
			cmd.setAnalogSmlvl(status.getAnalogSmlvl());
			cmd.setSmlvl(status.getSmlvl());
			cmd.setTemp(status.getTemp());
			cmd.setWaterlvl(status.getWlvl());
			cmd.execute();
			return Response.status(Status.CREATED).entity("Farm status successfully created.").build();
		} catch (SoftDevException e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Error while creating farm status").build();
		}
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/get/analogsm/{analogSmLevel}/sm/{smLevel}/temp/{temp}/water/{waterLevel}")
	public Response scanGet(@PathParam("analogSmLevel") Double analogSmLevel, @PathParam("smLevel") String smLevel,
			@PathParam("temp") Double temp, @PathParam("waterLevel") String waterLevel) {

			FarmStatus status = new FarmStatus();
			status.setAnalogSmlvl(analogSmLevel);
			status.setSmlvl(smLevel);
			status.setTemp(temp);
			status.setWlvl(waterLevel);
			return scan(status);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/display")
	public Response display() {
		try {
			GetLatestFarmStatusCmd cmd = new GetLatestFarmStatusCmd();
			cmd.execute();
			FarmStatus status = cmd.getLatestStatus();
			return Response.status(Status.OK).entity(status).build();
		} catch (SoftDevException e) {
			e.printStackTrace();
			return Response.status(Status.SERVICE_UNAVAILABLE).entity("Error occured while getting farm status").build();
		}
	}

}

