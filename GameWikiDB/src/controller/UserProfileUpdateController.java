package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import dao.DB;
//import dao.DBExceptions;
//import dao.GameDBUtility;
import model.User;
import service.UserService;

/**
 * Servlet implementation class UserProfileUpdate
 */
@WebServlet("/user_update")
public class UserProfileUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }
//   	GameDBUtility gUtil;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		
//		// TODO Auto-generated method stub
		String gamerTag = request.getParameter("gamer_tag");
		String email = request.getParameter("email");
		String username = request.getSession().getAttribute("username").toString();
		int age = Integer.parseInt(request.getParameter("age"));
		String name = request.getParameter("name");

		UserService userServ = new UserService(username);
		User user = userServ.getUser();
		user.setAge(age);
		user.setEmail(email);
		user.setGamerTag(gamerTag);
		user.setName(name);
		
		userServ.update();

		request.getRequestDispatcher("/user_profile").forward(request, response);
	}

}
