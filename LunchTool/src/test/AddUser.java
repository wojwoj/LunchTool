package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lunchtool.LunchDish;
import com.lunchtool.LunchMenu;
import com.lunchtool.Restaurant;
import com.lunchtool.RestaurantsUtils;
import com.lunchtool.User;
import com.lunchtool.UserUtils;
import com.lunchtool.bean.UserUtilsBean;
/**
 * Servlet implementation class AddUser
 */

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {

	@EJB(name = "user")
	UserUtils userUtils;
	
	@EJB(name = "restaurant")
	RestaurantsUtils restaurantsUtils;
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 
	      PrintWriter out = response.getWriter();
	     
	      response.setContentType("text/html");
	      out.println("<html><head><title>hej how</title></head><body>");
	      out.println("Hello jak sie masz</body></html>");
	      out.close();
	      
	      User wojtek = new User("wojtek", "wojtek","wojciech.wojcik","test123");
	      userUtils.storeUser(wojtek);
	      
	      Restaurant gesiPuch = new Restaurant(0,"Czeski Film");
	      LunchMenu lm = new LunchMenu();
	      LunchDish ld = new LunchDish(0, "Pierogi", 20);
	      LunchDish ld1 = new LunchDish(1, "Nalesniki", 25);
	      LunchDish ld2 = new LunchDish(2, "Kapusniak", 23);
	      LunchDish ld3 = new LunchDish(3, "Mielony", 22);
	      LunchDish ld4 = new LunchDish(4, "Deser", 11);
	      
	      restaurantsUtils.addRestaurant(gesiPuch);
	      restaurantsUtils.addMenuToResturant(lm, gesiPuch);
	      restaurantsUtils.addDishToMenu(lm, ld);
	      restaurantsUtils.addDishToMenu(lm, ld1);
	      restaurantsUtils.addDishToMenu(lm, ld2);
	      restaurantsUtils.addDishToMenu(lm, ld3);
	      restaurantsUtils.addDishToMenu(lm, ld4);
	      System.out.println("wszedl");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
