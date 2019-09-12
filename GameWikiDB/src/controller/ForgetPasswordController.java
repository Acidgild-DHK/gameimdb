package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

/**
 * Servlet implementation class ForgetPasswordController
 */
@WebServlet("/ForgotPassword")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordController() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String answer=(String)request.getParameter("answer");
		//response.getWriter().append((String)request.getSession().getAttribute("username"));
		UserService userServ = new UserService((String)request.getSession().getAttribute("username"));
		User user = userServ.getUser();
		response.getWriter().append(user.getAnswer()+" "+answer);
		if(user.getAnswer().equals(answer)) {
			
			request.getRequestDispatcher("forgotPasswordChange.jsp").forward(request, response);
		}
		else {
			request.getSession().setAttribute("FailedSecurityQuestion", 1);
		}
		//doGet(request, response);
	}

}
