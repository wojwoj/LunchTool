package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lunchtool.LunchDish;
import com.lunchtool.User;

/**
 * Servlet implementation class AddLunchDish
 */
@WebServlet("/AddLunchDish")
public class AddLunchDish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceUnit(unitName = "lunchtool")
	private EntityManagerFactory emFactory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLunchDish() {
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
		out.println("Lunch Dish Added</body></html>");
		out.close();

		LunchDish ld = new LunchDish(0, "Pizza",29);

		EntityManager em = null;

		em = emFactory.createEntityManager();
		em.getTransaction().begin();

		em.persist(ld);

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
