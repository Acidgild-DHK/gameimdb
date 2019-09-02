package homePage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegVerify
 */
@WebServlet("/RegVerify")
public class RegVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegVerify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO database again
		String user=request.getParameter("username");
		String sname=request.getParameter("name");
		String pass=request.getParameter("password");
		

			if(user.equals("dcolville")) {
				request.setAttribute("error", "already exists");
				RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
				rd.forward(request, response);
			}
			//dbstuff
			System.out.println(user+" "+sname+" "+pass);
			request.setAttribute("uname", user);
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("RegSuccess");
			rd.include(request, response);
	//		rd.forward(request,response);
			//response.sendRedirect("RegSuccess");
	
		//doGet(request, response);
	}

}
