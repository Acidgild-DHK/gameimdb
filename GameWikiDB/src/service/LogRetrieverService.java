package service;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Log;

/**
 * Servlet implementation class LogRetriever
 */
@WebServlet("/log_retriever")
public class LogRetrieverService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogRetrieverService() {
        super();
        // TODO Auto-generated constructor stub
    }
    
//    GameDBUtility gUtil;
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		gUtil = GameDBUtility.getInstance();
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
		String logID = request.getParameter("logID");
		Object userObj = request.getSession().getAttribute("username");
		if (userObj == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		String username = userObj.toString();
		
		LogService logServ = new LogService(username);
		Log log = logServ.get(logID);
		
		request.setAttribute("log", log);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
