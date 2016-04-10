package com.softdev.web.rh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softdev.core.bean.FarmStatus;
import com.softdev.core.bean.User;
import com.softdev.core.cmd.GetLatestFarmStatusCmd;
import com.softdev.core.cmd.GetUserByUserNameCmd;
import com.softdev.core.cmd.RegisterUserCmd;
import com.softdev.core.cmd.ValidateLoginCmd;
import com.softdev.core.exception.SoftDevException;

/**
 * Servlet implementation class AccessRH
 */
@WebServlet("/AccessRH")
public class AccessRH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccessRH() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		String cmd = request.getParameter("cmd");

		try {
			if (cmd.equalsIgnoreCase("validateLogin")) {
				nextPage = validateLogin(request);
			} else if (cmd.equalsIgnoreCase("registerUser")) {
				nextPage = registerUser(request);
			}else if (cmd.equalsIgnoreCase("displayLogs")) {
				nextPage = "logs.jsp";
			}else if (cmd.equalsIgnoreCase("displayAnalytic")) {
				nextPage = "analytics.jsp";
			} else if (cmd.equalsIgnoreCase("getProfile")) {
				nextPage = "profile.jsp";
			} else if (cmd.equalsIgnoreCase("displayAbout")) {
				nextPage = "about.jsp";
			} else if (cmd.equalsIgnoreCase("displayMain")) {
				nextPage = "controller?rh=dashboard&cmd=dashboard";
			} else if (cmd.equalsIgnoreCase("displayControl")) {
				nextPage = "control.jsp";
			} else if (cmd.equalsIgnoreCase("displayInfo")) {
				nextPage = "irrigation.jsp";
			} else if (cmd.equalsIgnoreCase("displayHelp")) {
				nextPage = "help.jsp";
			} else if (cmd.equalsIgnoreCase("doLogout")) {
				nextPage = doLogout(request);
			}

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		} catch (SoftDevException e) {
			System.out.println("Error in Access RH.");
			e.printStackTrace();
		}

	}

	private String doLogout(HttpServletRequest request) {
		String nextPage;
		//clear session
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		nextPage = "login.jsp";
		return nextPage;
	}

	private String registerUser(HttpServletRequest request) throws SoftDevException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String nextPage = null;
		
		if (username == null || username.equals("") || password == null || password.equals("") ||
				fname == null || fname.equals("") || lname == null || lname.equals("")){
			nextPage = "register.jsp";
			request.setAttribute("errorMessage","Fill up the fields");
		} else {
			RegisterUserCmd cmd = new RegisterUserCmd();
			cmd.setUserName(username);
			cmd.setPassword(password);
			cmd.setFName(fname);
			cmd.setLName(lname);
			cmd.execute();
			nextPage = "login.jsp";
		}
		return nextPage;

	}

	private String validateLogin(HttpServletRequest request) throws SoftDevException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nextPage = null;
		
		if (username == null || username.equals("") || password == null || password.equals("")){
			nextPage = "login.jsp";
			request.setAttribute("errorMessage","Invalid username or password");
			
		} else {
			User user = null;
			ValidateLoginCmd cmd = new ValidateLoginCmd();
			cmd.setUserName(username);
			cmd.setPassword(password);
			cmd.execute();
			boolean validLogin = cmd.isValidLogin();
			if (validLogin) {
				GetUserByUserNameCmd userCmd = new GetUserByUserNameCmd();
				userCmd.setUserName(username);
				userCmd.execute();
				user = userCmd.getUser();
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				GetLatestFarmStatusCmd cmd1 = new GetLatestFarmStatusCmd();
				cmd1.execute();
				FarmStatus status = cmd1.getLatestStatus();
				request.setAttribute("latestStatus", status);
			}
			if (validLogin) {
				if (user.getType().equalsIgnoreCase("A")) {
					nextPage = "admin.jsp";
				} else {
					nextPage = "main.jsp";
				}
			} else {
				nextPage = "login.jsp";
			}
			
		}
		return nextPage;
		
	}   

}
