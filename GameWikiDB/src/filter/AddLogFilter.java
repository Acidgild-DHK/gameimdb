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
import model.Log;
import db.GameDBUtility;

/**
 * Servlet Filter implementation class AddLogFilter
 */
@WebFilter("/user_add_log")
public class AddLogFilter implements Filter {
	GameDBUtility gUtil;
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
		
		ArrayList<Log> rec=gUtil.getLogTable(username, "<form action='userLogUpdate.jsp'>"
				+ "<input type='hidden' value='{{logID}}' name='logID'>"
				+ "<input type='submit' value='update'>"
				+ "</form>");
		boolean gameExists=false;
		for(Log l:rec) {
			if(l.getGameTitle().contentEquals("gameTitle")) {
				gameExists=true;
			}
			//System.out.println(l);
			
		}
		try {
			Integer.parseInt(timePlayed);
		}
		catch(NumberFormatException e) {
			request.setAttribute("error", "Time played must be an integer number");
			RequestDispatcher rd=request.getRequestDispatcher("userAddLog.jsp");
			rd.forward(request, response);
		}
		if(!gameExists) {
			request.setAttribute("error", "That game does not yet exist and add game is not yet implemented");
			RequestDispatcher rd=request.getRequestDispatcher("userAddLog.jsp");
			rd.forward(request, response);
		}
		if(review.getBytes().length>MAX_TEXT) {	
			request.setAttribute("error", "Review text is too long");
			RequestDispatcher rd=request.getRequestDispatcher("userAddLog.jsp");
			rd.forward(request, response);
		}
		System.out.println(request);
		System.out.println(response);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		gUtil = GameDBUtility.getInstance();
	}

}
