package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Log;
import model.Platform;
import service.LogService;
import service.PlatformService;

/**
 * Servlet implementation class UserLogUpdateController
 */
@WebServlet("/user_log_update")
public class UserLogUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogUpdateController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getSession().getAttribute("username").toString();
		String logID = request.getParameter("logID");
		String timePlayed = request.getParameter("time");
		String rating = request.getParameter("rating");
		String review = request.getParameter("review");
		String platformId = request.getParameter("platform");
		
		PlatformService platformServ = new PlatformService();
		Platform platform = platformServ.getPlatform(Integer.parseInt(platformId));
		LogService logServ = new LogService(username);
		Log log = logServ.get(logID);
		log.setTimePlayed(Integer.parseInt(timePlayed));
		log.setRating(Double.parseDouble(rating));
		log.setReviewText(review);
		log.setPlatform(platform);
		
		logServ.updateLog(log);
//		Log log = new Log(logID, null, Integer.parseInt(timePlayed), Double.parseDouble(rating), review, platform, null);
//		gUtil.updateLog(log);
		
		request.getRequestDispatcher("/user_logs").forward(request, response);
	}

}
