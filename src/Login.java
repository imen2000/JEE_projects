

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Commande;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException{
		   
		   ServletContext application= config.getServletContext();
	       Collection<Commande> commandes= new ArrayList<Commande>();
	       application.setAttribute("commandes", commandes);
	       
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		String person = req.getParameter("person");
		
		if (person!= null && person.equals("Admin") && req.getParameter("mdp").equals("admin") && req.getParameter("login").equals("admin")) {
			
			
			res.setContentType("text/html");
		    PrintWriter out = res.getWriter();
		    out.println("<HTML><BODY>");
		    out.println("<a href='Commandes'>Commandes non traitées<a>");
		    
		    out.println("</BODY></HTML>");
			out.close();				}
		else if (person!= null && person.equals("User") && req.getParameter("mdp").equals("user") && req.getParameter("login").equals("imen")){
			
			session.setAttribute("login", req.getParameter("login"));
			session.setAttribute("mdp", req.getParameter("mdp"));
			res.sendRedirect("Menu.html");
		}
		else 
			res.sendRedirect("login.html");
			
		
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
