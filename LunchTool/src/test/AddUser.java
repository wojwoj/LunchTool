package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lunchtool.User;
import com.lunctool.bean.UserUtils;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

/**
 * Servlet implementation class AddUser
 */

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {

	@EJB(name = "user")
	UserUtils userUtils;
	
	
	
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
	      
	      User wojtek = new User("wojtek", "wojtek","wojciech.wojcik", 6733);
	      
	      userUtils.storeUser(wojtek);
	      
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
