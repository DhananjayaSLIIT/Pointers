package package_Party;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package_Classes.Party;
import package_Classes.Wedding;
import package_Interfaces.InterfaceParty;
import package_Interfaces.InterfacePartyImp;

/**
 * Servlet implementation class GetPartyServlet
 */
@WebServlet("/GetPartyServlet")
public class GetPartyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPartyServlet() {
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
		
		response.setContentType("text/html");
		
		String action = request.getParameter("submit");
		if("update".equals(action)) {
			try {
				Party p = new Party();
				InterfaceParty ip = new InterfacePartyImp();
				
				ip.getParty(p);
				
				request.setAttribute("date", p.getPdate());
				request.setAttribute("type", p.getPtype());
				request.setAttribute("venue", p.getVenue());
				request.setAttribute("time", p.getTime());
				request.setAttribute("pcount", p.getPcount());
				request.setAttribute("decoration", p.getDecoration());
				request.setAttribute("photo", p.getPhoto());
				request.setAttribute("entertain", p.getEntertain());
				request.setAttribute("description", p.getDescription());
				
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/PartyUpdate.jsp");
				dispatch.forward(request, response);
			} catch (NumberFormatException | NullPointerException e) {
				e.printStackTrace();
			}
		
		}else if("finish".equals(action)) {
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
			dispatch.forward(request, response);
		}else if("cancel".equals(action)) {
			InterfaceParty ip = new InterfacePartyImp();
			Party p = new Party();
			ip.deleteParty(p);
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
			dispatch.forward(request, response);
			
		}
	
		
	}

}
