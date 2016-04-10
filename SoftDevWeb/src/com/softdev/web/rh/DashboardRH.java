package com.softdev.web.rh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softdev.core.bean.FarmStatus;
import com.softdev.core.cmd.GetLatestFarmStatusCmd;
import com.softdev.core.exception.SoftDevException;

@WebServlet("/DashboardRH")
public class DashboardRH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DashboardRH() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		String cmd = request.getParameter("cmd");

		try {
			if (cmd.equalsIgnoreCase("dashboard")) {
				nextPage = displayDashboard(request);
			}

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		} catch (SoftDevException e) {
			System.out.println("Error in Access RH.");
			e.printStackTrace();
		}

	}

	private String displayDashboard(HttpServletRequest request) throws SoftDevException {
		
		GetLatestFarmStatusCmd  cmd = new GetLatestFarmStatusCmd();
		cmd.execute();
		FarmStatus status = cmd.getLatestStatus();
		request.setAttribute("latestStatus", status);
		return "main.jsp";
	}

}
