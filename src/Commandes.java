

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Commande;

/**
 * Servlet implementation class Commandes
 */
@WebServlet("/Commandes")
public class Commandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletContext application= this.getServletConfig().getServletContext();
		Collection<Commande> commandes= (List<Commande>) application.getAttribute("commandes");
		res.setContentType("text/html");
	    PrintWriter out = res.getWriter();
	    out.println("<HTML><style>\r\n"
	    		+ "table, td, th, tr {\r\n"
	    		+ "	border: 1px solid black;\r\n"
	    		+ "}\r\n"
	    		
	    		+ "</style><BODY>");
	    out.println("<table>\r\n"
	    		+ "		<th>Nom</th>\r\n"
	    		+ "		<th>Prénom</th>\r\n"
	    		+ "		<th>Adresse</th>\r\n"
	    		+ "		<th>Prix total</th>");
	    int i=0;
	    for (Commande c:commandes) {
	    	out.println("<tr><td>"+c.getNom()+"</td>\r\n"
	    		
	    				
	    		+ "<td>"+c.getPrénom()+"</td>\r\n"
	    				
	    		+ "<td>"+c.getAdresse()+"</td>\r\n"
	    		+ "<td><a href=\"servlet.jsp?num="+i+"\">"+c.getPrixTotal()+"</a>"
	    				+ "</td></tr>\r\n");
	    	  i++;
	    	 }
	    		
	    		out.println("</table>");
	    		out.println("<br>");
	    		out.println("<br>");
	    out.println("<form method=\"POST\" action=\"Sauvegarder\"> <input  type=\"submit\" value=\"Sauvegarder\"></form>");
	    out.println("</BODY></HTML>");
	    
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=  Integer.parseInt(request.getParameter("num"));
		request.setAttribute("num",num);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("servlet.jsp");
		rd.forward(request, response);
		//response.sendRedirect("servlet.jsp");
		
	}

}
