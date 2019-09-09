package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AddLogFilter
 */
@WebFilter("/user_add_log")
public class AddLogFilter implements Filter {
	int MAX_TEXT=65535;
    /**
     * Default constructor. 
     */
    public AddLogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String username = ((HttpServletRequest) request).getSession().getAttribute("username").toString();
		String gameTitle = request.getParameter("game");
		String timePlayed = request.getParameter("time");
		String rating = request.getParameter("rating");
		String review = request.getParameter("review");
		String platform = request.getParameter("platform");
		
		if (gameTitle == null || gameTitle.isBlank()) {
			request.setAttribute("error", "Game Title cannot be blank");
			RequestDispatcher rd=request.getRequestDispatcher("userAddLog.jsp");
			rd.forward(request, response);
		}
		try {
			Integer.parseInt(timePlayed);
		}
		catch(NumberFormatException e) {
			request.setAttribute("error", "Time played must be an integer number");
			RequestDispatcher rd=request.getRequestDispatcher("userAddLog.jsp");
			rd.forward(request, response);
		}
		if(review.getBytes().length>MAX_TEXT) {	
			request.setAttribute("error", "Review text is too long");
			RequestDispatcher rd=request.getRequestDispatcher("userAddLog.jsp");
			rd.forward(request, response);
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
