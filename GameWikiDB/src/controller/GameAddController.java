package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;
import model.Platform;
import service.GameService;
import service.PlatformService;

/**
 * Servlet implementation class GameAddController
 */
@WebServlet("/game_add")
public class GameAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameAddController() {
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
		// TODO Auto-generated method stub
		GameService gameServ = new GameService();
		PlatformService platServ = new PlatformService();
		String gameTitle = request.getParameter("game_title");
		String publisher = request.getParameter("publisher");
		String releaseDate = request.getParameter("release_date");
		String description = request.getParameter("description");
		String esrb = request.getParameter("esrb");
		String genre = request.getParameter("genre");
		String[] platformString = request.getParameterValues("platforms");
		ArrayList<Platform> platforms = platServ.getPlatforms(platformString);
		
		
		Game game = new Game();
		game.setGameName(gameTitle);
		game.setPublisher(publisher);
		game.setReleaseDate(Date.valueOf(releaseDate));
		game.setDescription(description);
		game.setEsrb(esrb);
		game.setGenre(genre);
		game.setPlatforms(new HashSet<Platform>(platforms));
		
		System.out.println(gameServ.save(game));
		
		response.sendRedirect("games");
	}

}
