package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.Selection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lunchtool.LunchDish;
import com.lunchtool.LunchMenu;
import com.lunchtool.Restaurant;

/**
 * Servlet implementation class AddRestaurant
 */
@WebServlet("/AddRestaurant")
public class AddRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceUnit(unitName = "lunchtool")
	private EntityManagerFactory emFactory;

	public AddRestaurant() {
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
		
		EntityManager em = null;
		em = emFactory.createEntityManager();
		em.getTransaction().begin();
		
		try {
			Restaurant r = new Restaurant(2);
			LunchDish ld1 = new LunchDish(3, "Pasta", 33);
			LunchDish ld2 = new LunchDish(5, "Tomatto", 12);

			LunchMenu lm = new LunchMenu();

			lm.addLunchDishToMenu(ld1);
			lm.addLunchDishToMenu(ld2);

			lm.setRestaurant(r);	

			em.persist(ld2);
			em.persist(ld1);
			em.persist(r);
			em.persist(lm);

			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		em = emFactory.createEntityManager();
		em.getTransaction().begin();

		Restaurant r2 = (Restaurant)em.find(Restaurant.class, 2);
		out.println("<html><head><title>hej how</title></head><body>");
		out.println(r2.getId()+"</body></html>");
		out.close();
		em.getTransaction().commit();
	    em.close();
		
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
