package package_Party;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package_Classes.Party;
import package_Interfaces.InterfaceParty;
import package_Interfaces.InterfacePartyImp;

/**
 * Servlet implementation class UpdatePartyServlet
 */
@WebServlet("/UpdatePartyServlet")
public class UpdatePartyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePartyServlet() {
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
		
		
		Party p = new Party();
		InterfaceParty ip = new InterfacePartyImp();
		
		try {
			
			p.setPdate(req.getParameter("pdate"));
			p.setPtype(req.getParameter("ptype"));
			p.setVenue(req.getParameter("venue"));
			p.setTime(req.getParameter("time"));
			p.setPcount(Integer.parseInt(req.getParameter("pcount")));
			p.setDecoration(req.getParameter("decoration"));
			p.setPhoto(req.getParameter("photo"));
			p.setEntertain(req.getParameter("entertain"));
			p.setDescription(req.getParameter("description"));
			int budget = ip.calBudget(p);
			p.setBudget(budget);
			
			
			ip.updateParty(p);
			
			req.setAttribute("p", p);
			req.setAttribute("pdate", p.getPdate());
			req.setAttribute("ptype", p.getPtype());
			req.setAttribute("venue", p.getVenue());
			req.setAttribute("time", p.getTime());
			req.setAttribute("pcount", p.getPcount());
			req.setAttribute("decoration",p.getDecoration());
			req.setAttribute("photo", p.getPhoto());
			req.setAttribute("entertain", p.getEntertain());
			req.setAttribute("budget", p.getBudget());
			
			
			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/PartySummary.jsp");
			dispatch.forward(req, res);
			
		} catch (NullPointerException | NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
