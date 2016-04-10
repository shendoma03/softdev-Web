package com.softdev.ws.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.softdev.core.cmd.ValidateLoginCmd;
import com.softdev.core.exception.SoftDevException;
import com.softdev.ws.model.ServiceResponseStatus;
import com.softdev.ws.model.UserAccess;

@Path("/access")
public class UserAccessController {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/validate/user")
	public Response validateAccess(UserAccess user) {
		ValidateLoginCmd cmd = new ValidateLoginCmd();
		cmd.setUserName(user.getUserName());
		cmd.setPassword(user.getPassword());
		try {
			cmd.execute();
			boolean validLogin = cmd.isValidLogin();
			ServiceResponseStatus response = new ServiceResponseStatus();
			if (!validLogin) {
				response.setStatus("FAIL");
				response.setDescription("User login is invalid");
				return Response.status(Status.FORBIDDEN).entity(response.toString()).build();
			} else {
				response.setStatus("SUCCESS");
				response.setDescription("Login is valid");
				return Response.status(Status.OK).entity(response).build();
			}
		} catch (SoftDevException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("ERROR").build();
		}
	}
}
