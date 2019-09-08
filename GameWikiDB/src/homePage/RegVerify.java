package homePage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

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
		String username=request.getParameter("username").trim();
		String sname=request.getParameter("name").trim();
		String pass=request.getParameter("password").trim();
		String realName=request.getParameter("flname").trim();
		String age=request.getParameter("age").trim();
		
		String question = "";
		String answer = "";
		
		Properties prop=new Properties();
		
		UserService userServ = new UserService(username);
		User user = userServ.getUser();
			
		if (user != null) {
			request.setAttribute("error", "already exists");
			RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
			rd.forward(request, response);
		} else {
			user = new User();
			user.setUsername(username);
			user.setAge(Integer.valueOf(age));
			user.setName(realName);
			user.setEmail("");
			user.setPassword(pass);
			user.setGamerTag(sname);
			user.setQuestion(question);
			user.setAnswer(answer);
			
			userServ.save(user);
			request.getSession().setAttribute("username",user);
			request.getSession().setAttribute("login", true);
			response.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("/user_logs");
			rd.include(request, response);
		}
	}


}
