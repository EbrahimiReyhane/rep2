package RezerveTicketServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viweServlet0")
public class viweServlet0 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public viweServlet0() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New Ticket</a>");
		out.println("<h1>your Ticket</h1>");
		///TicketEntityManager ticketEntityManager  = new TicketEntityManager(); 
		out.print("<form action='ViweServlet' method='POST'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='number' name='id' value='id'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
