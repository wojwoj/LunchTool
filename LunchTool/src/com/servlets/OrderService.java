package com.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.jdbc.odbc.OdbcDef;

import com.lunchtool.LunchDish;
import com.lunchtool.Order;
import com.lunchtool.OrderUtils;
import com.lunchtool.Restaurant;
import com.lunchtool.RestaurantsUtils;
import com.lunchtool.User;

/**
 * Servlet implementation class OrderService
 */

public class OrderService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "OrderUtils")
	OrderUtils orderUtlis;

	@EJB(name = "restaurantUtlis")
	RestaurantsUtils restaurantsUtils;

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
		if (((String)request.getParameter("action")).equals("Order")) {
			String[] disher = request.getParameterValues("lunchDish");
			System.out.println(request.getParameterNames());
			System.out.println(request.getParameterValues("lunchDish"));
			User user = (User) request.getSession().getAttribute("user");
			for (int i = 0; i < disher.length; i++) {
				System.out.println(disher[i]);
				orderUtlis.addOrder(Integer.parseInt(disher[i]), user);
			}

			for (Order order : orderUtlis.getOrdersByUsedId(user.getId())) {
				System.out.print(order.getId());
			}

			HttpSession session = request.getSession(true);
			Restaurant restaurant = (Restaurant) restaurantsUtils
					.getRestaurantById(0);

			List menu = restaurant.getMenu().getMenu();
			if (menu != null) {
				HashMap<String, Integer> menuContent = new HashMap<String, Integer>();
				session.setAttribute("user", user);
				session.setAttribute("restaurant", restaurant);
			}
			List<Order> orders = orderUtlis.getOrdersByUsedId(user.getId());
			session.setAttribute("orders", orders);
			response.sendRedirect("./OrderForm.jsp");
		}
		else if (((String)request.getParameter("action")).equals("Cancel")) {
			User user = (User) request.getSession().getAttribute("user");
			orderUtlis.removeTodaysOrdersForUser(user.getId());
			request.getSession().setAttribute("orders", null);
			response.sendRedirect("./OrderForm.jsp");
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
