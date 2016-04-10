package com.softdev.web.rh;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softdev.core.bean.FarmStatus;
import com.softdev.core.cmd.GenerateReportCmd;
import com.softdev.core.exception.SoftDevException;

@WebServlet("/ReportRH")
public class ReportRH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportRH() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		String cmd = request.getParameter("cmd");

		try {
			if (cmd.equalsIgnoreCase("report")) {
				nextPage = generateReport(request);
			} else if (cmd.equalsIgnoreCase("analytics")) {
				nextPage = getAnalyticSmlvl(request);
			}
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		} catch (SoftDevException e) {
			System.out.println("Error in Report RH.");
			e.printStackTrace();
		}

	}

	private String getAnalyticSmlvl(HttpServletRequest request) {
		String temperature = request.getParameter("temperature");
		int temp = Integer.parseInt(temperature);
		Double psmlvl = (-140.8 * temp) + 4707.1;
		request.setAttribute("psmlvl",psmlvl);
		return "analytics.jsp";
	}

	private String generateReport(HttpServletRequest request) throws SoftDevException {
		String month = request.getParameter("month");
		GenerateReportCmd cmd = new GenerateReportCmd();
		cmd.setMonth(month);
		cmd.execute();
		List<FarmStatus> farmStatuses = cmd.getFarmStatuses();
		request.setAttribute("farmStatuses", farmStatuses);
		return "logs.jsp";
	}
}
