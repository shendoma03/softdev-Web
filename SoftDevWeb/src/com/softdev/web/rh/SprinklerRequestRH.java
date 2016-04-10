package com.softdev.web.rh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softdev.core.cmd.CreateSprinklerRequestCmd;
import com.softdev.core.exception.SoftDevException;

/**
 * Servlet implementation class AccessRH
 */
@WebServlet("/SprinklerRequestRH")
public class SprinklerRequestRH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SprinklerRequestRH() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		String cmd = request.getParameter("cmd");

		try {
			if (cmd.equalsIgnoreCase("switch")) {
				nextPage = createSprinklerRequest(request);
			}

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		} catch (SoftDevException e) {
			System.out.println("Error in Access RH.");
			e.printStackTrace();
		}

	}

	private String createSprinklerRequest(HttpServletRequest request) throws SoftDevException {
		String op = request.getParameter("operation");
		op = op == null ? "" : op.toLowerCase();
		CreateSprinklerRequestCmd cmd = new CreateSprinklerRequestCmd();
		cmd.setCreateUser("my-user");
		boolean operation = op.equals("on") ? true : false;
		cmd.setOperation(operation);
		cmd.execute();
		request.setAttribute("message", "Request has been sent. Please wait.");
		return "control.jsp";
	}

}
