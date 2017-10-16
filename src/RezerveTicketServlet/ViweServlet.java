package RezerveTicketServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ViweServlet")
public class ViweServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViweServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New Ticket</a>");
		out.println("<h1>Tickets List</h1>");
		TicketEntityManager ticketEntityManager  = new TicketEntityManager(); 
		List<Ticket> list= ticketEntityManager .getAllTickets();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>from</th><th>to</th><th>date</th><th>flightNumber</th><th>Edit</th><th>Delete</th></tr>");
		for(Ticket t:list){
			out.print("<tr><td>"+t.getPassengerName()+"</td><td>"+t.getFrom()+"</td><td>"+t.getTo()+"</td><td>"+t.getDate()+"</td><td>"+t.getFlightNumber()+"</td><td><a href='UpdateServlet?idt="+t.getId()+"'>edit</a></td><td><a href='DeleteServlet?idt="+t.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		TicketEntityManager ticketEntityManager  = new TicketEntityManager(); 
		String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);
		Ticket t= ticketEntityManager.getOneticket(id);
				
				out.print("<table border='1' width='100%'");
				out.print("<tr><th>Id</th><th>Name</th><th>from</th><th>to</th><th>date</th><th>flightNumber</th><th>Edit</th><th>Delete</th></tr>");
				
					out.print("<tr><td>"+t.getId()+"</td><td>"+t.getPassengerName()+"</td><td>"+t.getFrom()+"</td><td>"+t.getTo()+"</td><td>"+t.getDate()+"</td><td>"+t.getFlightNumber()+"</td><td><a href='UpdateServlet?id="+t.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+t.getId()+"'>delete</a></td></tr>");
				
				out.print("</table>");
				
				out.close();
	}

}
