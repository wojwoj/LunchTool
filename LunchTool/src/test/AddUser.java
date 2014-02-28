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

import com.lunchtool.User;

/**
 * Servlet implementation class AddUser
 */

//@WebServlet("/AddUser")
public class AddUser extends HttpServlet {


	  @PersistenceUnit(unitName = "lunchtool")
	  private EntityManagerFactory emFactory;
	
	
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
	      out.println("<html><head><title>Query Results</title></head><body>");
	      out.println("asdasasasd</body></html>");
	      out.close();
	      
	      User wojtek = new User("wojtek", "wojtek", 6733);
	      
	      EntityManager em = null;
	      
	      em = emFactory.createEntityManager();
	      em.getTransaction().begin();

	      // em.persist(addr);
	      em.persist(wojtek);
	      
	      em.getTransaction().commit();

	      
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
