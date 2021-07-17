package package_Wedding;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package_Classes.Wedding;
import package_Interfaces.InterfaceWedding;
import package_Interfaces.InterfacesWedImpl;

/**
 * Servlet implementation class Getbooking
 */
@WebServlet("/Getbooking")
public class Getbooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getbooking() {
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
	
		String action  = req.getParameter("submit");
		Wedding w  = new Wedding();
		InterfaceWedding iw = new InterfacesWedImpl();
		try {
			if("update".equals(action)) {
				iw.getBookings(w);
				req.setAttribute("date", w.getWedDate());
			
				req.setAttribute("time", w.getTime());
				req.setAttribute("pax_count", w.getPaxCount());
				req.setAttribute("theme", w.getTheme());
				
				req.setAttribute("decoration", w.getDecoration());
				req.setAttribute("photo", w.getPhoto());
				
				req.setAttribute("entertain", w.getEntertain());
				req.setAttribute("poruwa", w.getPoruwaCero());
				
			
				req.setAttribute("description", w.getDescription());
				
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/Update.jsp");
				dispatch.forward(req, res);		
			}else if("cancel".equals(action)) {
				iw.deleteWedding(w);
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
				dispatch.forward(req, res);
			}else if("finish".equals(action)) {
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
				dispatch.forward(req, res);
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
	}

}
