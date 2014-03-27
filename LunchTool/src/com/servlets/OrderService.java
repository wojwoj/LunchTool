package com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lunchtool.OrderUtils;
import com.lunchtool.User;

/**
 * Servlet implementation class OrderService
 */

public class OrderService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "OrderUtils")
	OrderUtils orderUtlis;

	public OrderService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] disher = request.getParameterValues("lunchDish");
		System.out.println(request.getParameterNames());
		System.out.println(request.getParameterValues("lunchDish"));
		User user = (User) request.getSession().getAttribute("user");
		for (int i = 0; i < disher.length; i++) {
			System.out.println(disher[i]);
			orderUtlis.addOrder(Integer.parseInt(disher[i]), user);
		}

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
