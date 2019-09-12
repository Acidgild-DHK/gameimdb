package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;
import model.Log;
import model.Platform;
import model.User;
import service.GameService;
import service.LogService;
import service.PlatformService;
import service.UserService;

/**
 * Servlet implementation class UserLogAddController
 */
@WebServlet("/user_add_log")
public class UserLogAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogAddController() {
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
		String gameTitle = request.getParameter("game");
		String timePlayed = request.getParameter("time");
		String rating = request.getParameter("rating");
		String review = request.getParameter("review");
		String platformId = request.getParameter("platform");
		
		LogService logServ = new LogService(username);
		PlatformService platformServ = new PlatformService();
		Platform platform = platformServ.getPlatform(Integer.parseInt(platformId));
		GameService gameServ = new GameService(gameTitle);
		Game game = gameServ.get();
		if (game == null) {
			game = new Game();
			game.setGameName(gameTitle);
			game.getPlatforms().add(platform);
			game.setGameID(Integer.parseInt(gameServ.save(game)));
		}
		
		System.out.println(game);
		Log log = logServ.get(username + ":" + game.getGameID());
		if (log == null) {
			log = new Log();
		} else {
			request.getSession().setAttribute("error", "Log already exists.");
			response.sendRedirect("userAddLog.jsp");
			return;
		}
		request.getSession().setAttribute("error", null);
		log.setGame(game);
		log.setPlatform(platform);
		log.setRating(Double.parseDouble(rating));
		log.setReviewText(review);
		log.setTimePlayed(Integer.parseInt(timePlayed));
		logServ.addLog(log);
//		Log log = new Log(null, gameTitle, Integer.parseInt(timePlayed), Double.parseDouble(rating), review, platform, null);
//		
//		gUtil.addLog(username, log);
		
		request.getRequestDispatcher("/user_logs").forward(request, response);
	}

}
