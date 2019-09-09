package filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RegFilter
 */
@WebFilter("/RegVerify")
public class RegFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RegFilter() {
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
		// TODO add more filters
		String user=request.getParameter("username");
		String sname=request.getParameter("name");
		String pass=request.getParameter("password");
		String realName=request.getParameter("flname");
		String age=request.getParameter("age");
		boolean isValid=true;
		if(user.isEmpty()||sname.isEmpty()||pass.isEmpty()) {
			isValid=false;
			request.setAttribute("error", "empty");
			RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
			rd.forward(request, response);
		}
		if(pass==null) {
			isValid=false;
			request.setAttribute("error", "empty");
			RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
			rd.forward(request, response);
			//chain.doFilter(request, response);
		}
		// pass the request along the filter chain
		HttpServletResponse rs=(HttpServletResponse) response;
		
		if(age!=null && Integer.parseInt(age)<0 || Integer.parseInt(age)>150) {
			isValid=false;
			request.setAttribute("error", "Invalid age");
			RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
			rd.forward(request, response);
		}
		Pattern p=Pattern.compile("[^a-zA-Z]");
		
		if(p.matcher(realName).find()) {
			isValid=false;
			request.setAttribute("error", "Invalid name");
			RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
			rd.forward(request, response);
		}
		if(pass.length()>25) {
			isValid=false;
			request.setAttribute("error", "Password too long");
			RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
			rd.forward(request, response);
			//rs.sendRedirect("register1.jsp");
		}
		if(isValid) {
			chain.doFilter(request, response);
		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
