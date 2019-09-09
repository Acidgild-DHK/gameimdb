package filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import db.GameDBUtility;
import model.Log;

/**
 * Servlet Filter implementation class UpdateLogFilter
 */
@WebFilter("/user_log_update")
public class UpdateLogFilter implements Filter {
	int MAX_TEXT=65535;
	GameDBUtility gUtil;
    /**
     * Default constructor. 
     */
    public UpdateLogFilter() {
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
		String timePlayed = request.getParameter("time");
		String rating = request.getParameter("rating");
		String review = request.getParameter("review");
		String platform = request.getParameter("platform");
		
		ArrayList<Log> rec=gUtil.getLogTable(username, "<form action='userLogUpdate.jsp'>"
				+ "<input type='hidden' value='{{logID}}' name='logID'>"
				+ "<input type='submit' value='update'>"
				+ "</form>");
	
		try {
			Integer.parseInt(timePlayed);
		}
		catch(NumberFormatException e) {
			request.setAttribute("error", "Time played must be an integer number");
			RequestDispatcher rd=request.getRequestDispatcher("userLogUpdate.jsp");
			rd.forward(request, response);
		}
		if(review.getBytes().length>MAX_TEXT) {	
			request.setAttribute("error", "Review text is too long");
			RequestDispatcher rd=request.getRequestDispatcher("userLogUpdate.jsp");
			rd.forward(request, response);
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		gUtil=GameDBUtility.getInstance();
		// TODO Auto-generated method stub
	}

}
