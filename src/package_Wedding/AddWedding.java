package package_Wedding;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.internal.dynalink.beans.StaticClass;
import package_Classes.Wedding;
import package_Interfaces.InterfaceWedding;
import package_Interfaces.InterfacesWedImpl;

/**
 * Servlet implementation class AddWedding
 */
@WebServlet("/AddWedding")
public class AddWedding extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWedding() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		res.setContentType("text/html");
		
		Wedding w = new Wedding();
		InterfaceWedding iw = new InterfacesWedImpl();
		
		
		try {
		w.setBid(iw.getBID());		
		w.setWedDate(req.getParameter("date"));
		w.setVenue(req.getParameter("venue"));
		w.setTime(req.getParameter("time"));
		w.setPaxCount(Integer.parseInt((req.getParameter("pax_count"))));
		w.setTheme(req.getParameter("theme"));
		w.setDressing(req.getParameter("dress"));
		w.setDecoration(req.getParameter("decoration"));
		w.setPhoto(req.getParameter("photo"));
		w.setCarRental(req.getParameter("cars"));
		w.setEntertain(req.getParameter("entertain"));
		w.setPoruwaCero(req.getParameter("poruwa"));
		w.setCakeDesign(req.getParameter("cake"));
		w.setCardDesign(req.getParameter("card"));
		w.setDescription(req.getParameter("description"));
		int budget = iw.calBudget(w);
		w.setBudget(budget);
	
		iw.addWedding(w);
		
		req.setAttribute("w", w);
		req.setAttribute("bid", w.getBid());
		req.setAttribute("date", w.getWedDate());
		req.setAttribute("venue", w.getVenue());
		req.setAttribute("time", w.getTime());
		req.setAttribute("pax_count", w.getPaxCount());
		req.setAttribute("theme", w.getTheme());
		req.setAttribute("dress", w.getDressing());
		req.setAttribute("decoration", w.getDecoration());
		req.setAttribute("photo", w.getPhoto());
		req.setAttribute("carrental", w.getCarRental());
		req.setAttribute("entertain", w.getEntertain());
		req.setAttribute("poruwa", w.getPoruwaCero());
		req.setAttribute("cake", w.getCakeDesign());
		req.setAttribute("card", w.getCardDesign());
		req.setAttribute("budget", w.getBudget());
			
		RequestDispatcher dispch = getServletContext().getRequestDispatcher("/summary.jsp");
		dispch.forward(req, res);
		
		
		}catch( NumberFormatException | NullPointerException nfe) {
			RequestDispatcher rd = req.getRequestDispatcher("/WeddingPlanning.jsp");
			rd.include(req, res);
			nfe.printStackTrace();
		}
		
		
	}

}
