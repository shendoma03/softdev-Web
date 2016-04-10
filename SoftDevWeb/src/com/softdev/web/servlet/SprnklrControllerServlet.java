package com.softdev.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softdev.core.bean.User;

/**
 * Servlet implementation class SprnklrControllerServlet
 */
@WebServlet("/controller")
public class SprnklrControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SprnklrControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the request handler
		String rh = request.getParameter("rh");
		String nextPage = null;
		
		if (rh == null) {
			nextPage = "login.jsp";
		} else {
			// build the RH class
			StringBuilder sb = new StringBuilder();
			sb.append(rh.substring(0, 1).toUpperCase());
			sb.append(rh.substring(1));
			sb.append("RH");
			nextPage = sb.toString();
		}
		//validate session
		String cmd = request.getParameter("cmd");
		if (!(cmd.equals("validateLogin") || cmd.equals("registerUser"))) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user == null) {
				nextPage = "login.jsp";
			}
		}

		// forward the request
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
