package com.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.caucho.rewrite.Forward;
import com.lunchtool.LunchDish;
import com.lunchtool.Order;
import com.lunchtool.OrderUtils;
import com.lunchtool.Restaurant;
import com.lunchtool.RestaurantsUtils;
import com.lunchtool.User;
import com.lunchtool.UserUtils;

public class AuthenticationAndLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "userUtlis")
	UserUtils userUtlis;

	@EJB(name = "OrderUtils")
	OrderUtils orderUtlis;

	@EJB(name = "restaurantUtlis")
	RestaurantsUtils restaurantsUtils;

	public AuthenticationAndLogin() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("action") != null) {
			if (((String) request.getParameter("action")).equals("logout")) {
				request.getSession().invalidate();
				response.sendRedirect("./index.jsp");
			}

		} else {
			String login = request.getParameter("login");
			String password = request.getParameter("password");

			if (userUtlis.authenticateUser(login, password)) {
				HttpSession session = request.getSession(true);
				User user = userUtlis.findUserByLogin(login);
				Restaurant restaurant = (Restaurant) restaurantsUtils
						.getRestaurantById(0);
				List menu = restaurant.getMenu().getMenu();
				if (menu != null) {
					HashMap<String, Integer> menuContent = new HashMap<String, Integer>();
					// for (int i = 0; i < menu.size(); i++) {
					// menuContent.put(((LunchDish)menu.get(i)).getDishName(),((LunchDish)menu.get(i)).getPrice());
					// }
					// // session.setAttribute("menu", menuContent);
					session.setAttribute("user", user);
					session.setAttribute("restaurant", restaurant);
					List<Order> orders = orderUtlis.getOrdersByUsedId(user
							.getId());
					session.setAttribute("orders", orders);
					// request.getRequestDispatcher("./OrderForm.jsp").forward(
					// request, response);
					response.sendRedirect("./OrderForm.jsp");
				}

			} else {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", null);
				session.setAttribute("message", "Wrong login or password");
				response.sendRedirect("./index.jsp");
			}

		}
	}

}
