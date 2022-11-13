

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accesBD.CommandeDAO;
import beans.Commande;

/**
 * Servlet implementation class Sauvegarder
 */
@WebServlet("/Sauvegarder")
public class Sauvegarder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sauvegarder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application= this.getServletConfig().getServletContext();
		Collection<Commande> commandes= (List<Commande>) application.getAttribute("commandes");
		Iterator<Commande> iterator = commandes.iterator();
		CommandeDAO dao= new CommandeDAO();
		PrintWriter out = response.getWriter();
	     while (iterator.hasNext()) {
	            Commande c= iterator.next();
	            try {
	            
					dao.ajouter(c);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            iterator.remove();
	      }
	     
	     out.println("Commandes vidées");
	     List<Commande> c= (List<Commande>) commandes;
	     out.println(c.size());
	     application.setAttribute("commandes", commandes);
	     HttpSession session=request.getSession();
	     session.invalidate();
	     response.sendRedirect("login.html");
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
