package RezerveTicketServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/filter")
public class filter implements Filter {

  
    public filter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);
		TicketEntityManager entity = new TicketEntityManager();
		if (entity.is_valid(id)) {
			
			chain.doFilter(req, resp);

		} else {
			out.print("id is  worrong!");
			RequestDispatcher rd = req.getRequestDispatcher("viweServlet0");
			rd.include(req, resp);
		}
	}

	
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
