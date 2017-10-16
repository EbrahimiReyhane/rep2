package RezerveTicketServlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.*;

public class MyFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter out = resp.getWriter();
			String flightnumber = req.getParameter("flight");
			int number = Integer.parseInt(flightnumber);
			if (number >= 100 && number <= 900) {
				chain.doFilter(req, resp);// sends request to next resource
				String date = req.getParameter("date");
				if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
					chain.doFilter(req, resp);// sends request to next resource
				} else {
					out.print("date is  worrong!");
					RequestDispatcher rd = req.getRequestDispatcher("index.html");
					rd.include(req, resp);
				}

			} else {
				out.print("flight number is  worrong!");
				RequestDispatcher rd = req.getRequestDispatcher("index.html");
				rd.include(req, resp);
			}

		

		
			
		}



	public void destroy() {
	}

}
