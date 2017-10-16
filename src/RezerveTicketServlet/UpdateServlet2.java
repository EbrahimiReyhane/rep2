package RezerveTicketServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String name = req.getParameter("name");
    	String to = req.getParameter("to");
    	String from = req.getParameter("from");
    	String date = req.getParameter("date");
    	String flight = req.getParameter("flight");
    	int flightNumber = Integer.parseInt(flight);
    	Ticket ticket = new Ticket();
    	ticket.setPassengerName(name);
    	ticket.setFrom(from);
    	ticket.setDate(date);
    	ticket.setTo(to);
    	ticket.setFlightNumber(flightNumber);
    	TicketEntityManager ticketEntityManager = new TicketEntityManager ();
    	int status=ticketEntityManager.update(ticket);
		if(status>0){
			resp.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
