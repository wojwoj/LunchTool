package com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lunchtool.RegistrationUtils;
public class RegistrationService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "registrationUtils")
	RegistrationUtils registrationUtlis;

    public RegistrationService() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		registrationUtlis.registerUser(name, surname, login, password);
		HttpSession session = request.getSession(true);
		session.setAttribute("message", "Registration OK");
		response.sendRedirect("./index.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
