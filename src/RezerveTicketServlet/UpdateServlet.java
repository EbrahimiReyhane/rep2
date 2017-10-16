package RezerveTicketServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>UpdateTicket</h1>");
		String Tid=request.getParameter("idt");
		int id=Integer.parseInt(Tid);
		TicketEntityManager ticketEntityManagr = new TicketEntityManager ();
		Ticket t= ticketEntityManagr. getOneticket(id);
		
		out.print("<form action='UpdateServlet2' method='GET'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+t.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+t.getPassengerName()+"'/></td></tr>");
		out.print("<tr><td>From:</td><td><input type='text' name='from' value='"+t.getFrom()+"'/></td></tr>");
		out.print("<tr><td>To:</td><td><input type='text' name='to' value='"+t.getTo()+"'/></td></tr>");
		out.print("<tr><td>date:</td><td><input type='text' name='date' value='"+t.getDate()+"'/></td></tr>");
		out.print("<tr><td>flightNumber:</td><td><input type='number' name='flight' value='"+t.getFlightNumber()+"'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
