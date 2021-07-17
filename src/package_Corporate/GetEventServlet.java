package package_Corporate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package_Classes.Corporate;
import package_Interfaces.InterfaceCorporate;
import package_Interfaces.InterfaceCorporateImp;


/**
 * Servlet implementation class GetEventServlet
 */
@WebServlet("/GetEventServlet")
public class GetEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEventServlet() {
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
		
		String action = request.getParameter("submit");
		if("update".equals(action)) {
			try {
				Corporate c = new Corporate();
				InterfaceCorporate ic = new InterfaceCorporateImp();
				
				ic.getEvent(c);
				
				request.setAttribute("date", c.getDate());
				request.setAttribute("type", c.getEtype());
				request.setAttribute("venue", c.getVenue());
				request.setAttribute("time", c.getTime());
				request.setAttribute("pax_count", c.getPcount());
				request.setAttribute("furniture", c.getF_rental());
				request.setAttribute("description", c.getDescrition());
				
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/EventUpdate.jsp");
				dispatch.forward(request, response);
			} catch (NumberFormatException | NullPointerException e) {
				e.printStackTrace();
			}
		
		}else if("finish".equals(action)) {
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
			dispatch.forward(request, response);
		}else if("cancel".equals(action)) {
			Corporate c = new Corporate();
			InterfaceCorporate ic = new InterfaceCorporateImp();
			ic.deleteEvent(c);
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
			dispatch.forward(request, response);
			
		}
		
	}

}
