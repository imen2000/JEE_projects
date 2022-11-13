

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;

import beans.Commande;
import beans.Pizza;

/**
 * Servlet implementation class Ajouter
 */
@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Ajouter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    HttpSession session = req.getSession(true);
	    
		Commande c1=(Commande) session.getAttribute("commande");
		
	    if(c1==null)
	    	c1=new Commande();
		else 
         c1=(Commande)session.getAttribute("commande");
		if (req.getParameterValues("pizza")!=null)	{
		 String[] pizzas= req.getParameterValues("pizza");	
		 
	       for(String a:pizzas) {
			    	
			    String prix= req.getParameter("prix"+a);
			    c1.getListePizza().add(new Pizza(a, Double.parseDouble(prix.trim())));
			    	
			    }
	       session.setAttribute("commande", c1);
			res.sendRedirect ("Menu.html");}
		else{
			PrintWriter out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><body>"
					
					+ "  <p></p>\r\n"
					+ "<script> alert(\"Veuillez choisir un type de pizza avant l'ajout !\");"
					
				
					+ "</script>");
					
					//+ "</div> <form action=\"Menu.html\" method=\"GET\" ><input type=\"submit\" value=\"Afficher Menu\"></form>");
			
			out.println("</body></html>");
			 session.setAttribute("commande", c1);
			 
			 res.setHeader ("Refresh","1;URL=http://localhost:8090/exPizzasJEE/Menu.html");
			 //res.sendRedirect ("Menu.html");
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
