package com.softdev.ws.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.softdev.core.bean.SprinklerRequest;
import com.softdev.core.cmd.CreateSprinklerRequestCmd;
import com.softdev.core.cmd.GetLatestPendingSprinklerRequestCmd;
import com.softdev.core.cmd.UpdatePendingSprinklerRequestToCompleteCmd;
import com.softdev.core.exception.SoftDevException;
import com.softdev.ws.model.ServiceResponseStatus;

@Path("/request")
public class SprinklerRequestController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/latest")
	public Response getLatestPendingSprinklerRequest() {
		GetLatestPendingSprinklerRequestCmd cmd = new GetLatestPendingSprinklerRequestCmd();
		try {
			cmd.execute();
			SprinklerRequest pendingRequest = cmd.getPendingRequest();
			return Response.status(Status.OK).entity(pendingRequest).build();
		} catch (SoftDevException e) {
			e.printStackTrace();
			return Response.status(Status.SERVICE_UNAVAILABLE).entity("Error occured while getting pending request").build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{requestId}/complete")
	public Response updatePendingRequestToComplete(@PathParam("requestId")Integer requestId) {
		UpdatePendingSprinklerRequestToCompleteCmd cmd = new UpdatePendingSprinklerRequestToCompleteCmd();
		try {
			cmd.setRequestId(requestId);
			cmd.execute();
			return Response.status(Status.OK).entity("Sprinkler request succsessfully updated.").build();
		} catch (SoftDevException e) {
			e.printStackTrace();
			return Response.status(Status.SERVICE_UNAVAILABLE).entity("Error occured while updating sprinkler request").build();
		}
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{operation}/operation")
	public Response operateSprinkler(@PathParam("operation")String operation) {
		CreateSprinklerRequestCmd cmd = new CreateSprinklerRequestCmd();
		try {
			operation = operation == null ? "" : operation.toLowerCase();
			cmd.setCreateUser("sprnklrws");
			boolean operation1 = operation.equals("on") ? true : false;
			cmd.setOperation(operation1);
			cmd.execute();
			ServiceResponseStatus response = new ServiceResponseStatus();
			response.setStatus("SUCCESS");
			response.setDescription("Sprinkler request successfully created");
			return Response.status(Status.CREATED).entity(response).build();
		} catch (SoftDevException e) {
			e.printStackTrace();
			return Response.status(Status.SERVICE_UNAVAILABLE).entity("Error occured while updating sprinkler request").build();
		}
	}
	
}
