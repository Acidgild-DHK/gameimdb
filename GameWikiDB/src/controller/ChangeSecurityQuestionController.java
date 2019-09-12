package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

/**
 * Servlet implementation class ChangeSecurityQuestion
 */
@WebServlet("/ChangeQuestions")
public class ChangeSecurityQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeSecurityQuestionController() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question=(String) request.getParameter("question");
		String answer=(String) request.getParameter("answer");
		String password=(String) request.getParameter("password");
		String username=(String) request.getSession().getAttribute("username");
		UserService userServ = new UserService(username);
		User user = userServ.getUser();
		if(user.getPassword().equals(password)) {
			System.out.println(user.getAnswer());
			user.setQuestion(question);
			user.setAnswer(answer);
			
			userServ.update();
			UserService userServ2 = new UserService(username);
			User user2 = userServ2.getUser();
			System.out.println(user2.getAnswer());
			request.getRequestDispatcher("/user_profile").forward(request, response);
		}
		else {
			//TODO: forward to error
			request.getSession().setAttribute("error", "Password invalid, could not change security question.");
			request.getRequestDispatcher("changeSecurityQuestion.jsp").forward(request, response);
		}
		
		
	}

}
