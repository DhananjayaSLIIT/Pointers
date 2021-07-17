package package_Corporate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.SetSplitState;
import package_Classes.Corporate;
import package_Interfaces.InterfaceCorporate;
import package_Interfaces.InterfaceCorporateImp;

/**
 * Servlet implementation class UpdateEventServlet
 */
@WebServlet("/UpdateEventServlet")
public class UpdateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEventServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		
		Corporate c = new Corporate();
		InterfaceCorporate ic = new InterfaceCorporateImp();
		
		try {
			
			c.setDate(request.getParameter("edate"));
			c.setEtype(request.getParameter("etype"));
			c.setVenue(request.getParameter("venue"));
			c.setTime(request.getParameter("time"));
			c.setPcount(Integer.parseInt(request.getParameter("pax_count")));
			c.setF_rental(request.getParameter("furniture"));
			c.setDescrition(request.getParameter("description") );
			int budget = ic.calBudget(c);
			c.setBudget(budget);
			ic.updateEvent(c);
			
			request.setAttribute("c", c);
			request.setAttribute("edate", c.getDate());
			request.setAttribute("etype", c.getEtype());
			request.setAttribute("venue", c.getVenue());
			request.setAttribute("time", c.getTime());
			request.setAttribute("pax_count", c.getPcount());
			request.setAttribute("furniture", c.getF_rental());
			request.setAttribute("budget", c.getBudget());
			
			RequestDispatcher dispath = getServletContext().getRequestDispatcher("/CorporateSummary.jsp");
			dispath.forward(request, response);
			
			
		} catch (NumberFormatException | NullPointerException e) {
			e.printStackTrace();
		}
		
	}

}
