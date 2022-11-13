

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Commande;
import beans.Pizza;


/**
 * Servlet implementation class Commander
 */
@WebServlet("/Commander")
public class Commander extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commander() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  HttpSession session = req.getSession(true);
			Commande c1=(Commande) session.getAttribute("commande");
			
		    if(c1==null)
		    	c1=new Commande();
			else 
	         c1=(Commande)session.getAttribute("commande");
	 if(((req.getParameter("nom")!="") &&(req.getParameter("prenom")!=""))&&(req.getParameter("adr")!="adr")) {

		c1.setNom(req.getParameter("nom"));
		c1.setPrénom(req.getParameter("prenom"));
		c1.setAdresse(req.getParameter("adr"));
		List<Pizza> l =c1.getListePizza();
		double prix=0;
		for(Pizza pi:l) {
			prix+=pi.getPrix();
		}
		c1.setPrixTotal(prix);
		ServletContext application= this.getServletConfig().getServletContext();
		Collection<Commande> commandes= (List<Commande>) application.getAttribute("commandes");
		commandes.add(c1);
	    application.setAttribute("commandes", commandes);
	    session.invalidate();
	    res.sendRedirect("login.html");}
	 else {
		    PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><body>"
					
					+ "  <p></p>\r\n"
					+ "<script> alert(\"Veuillez entrer vos coordonnées complètes!\");"
					
				
					+ "</script>");
					
								
			out.println("</body></html>");
			 
			 res.setHeader ("Refresh","1;URL=http://localhost:8090/exPizzasJEE/formulaire.html");
	 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
