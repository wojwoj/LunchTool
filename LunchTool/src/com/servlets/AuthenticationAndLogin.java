package com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.lunchtool.UserUtils;
import com.lunchtool.bean.UserUtilsBean;

/**
 * Servlet implementation class AuthenticationAndLogin
 */


public class AuthenticationAndLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "userUtlis")
	UserUtils userUtlis;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationAndLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if(userUtlis.authenticateUser(login, password))
		{
		System.out.println(login + "" + password);
		HttpSession session = request.getSession(false);
		session.setAttribute("wojwoj", "true");
		response.sendRedirect("./index.jsp");
		}else{ 
			System.out.println("Access deniaed");
		}
			
	}

}
