package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
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

//import dao.DB;
//import dao.DBConnection;
//import dao.DBExceptions;

/**
 * Servlet implementation class GamesUpdate
 */
@WebServlet("/game_update")
public class GamesUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GamesUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }
//    DB db =null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
		PlatformService platServ = new PlatformService();
		String gameId = request.getParameter("gameId");
		String publisher = request.getParameter("publisher");
		String release_date = request.getParameter("release_date");
		String description = request.getParameter("description");
		String esrb = request.getParameter("esrb");
		String genre = request.getParameter("genre");
		String[] platformString = request.getParameterValues("platforms");
		ArrayList<Platform> platforms = platServ.getPlatforms(platformString);
		GameService gameServ = new GameService();
		Game game = gameServ.get(Integer.parseInt(gameId));
		System.out.println("updating " + game);
		game.setPublisher(publisher);
		System.out.println(Date.valueOf(release_date));
		game.setReleaseDate(Date.valueOf(release_date));
		game.setDescription(description);
		game.setEsrb(esrb);
		game.setGenre(genre);
		game.getPlatforms().clear();
		game.getPlatforms().addAll(platforms);
		gameServ.update(game);
		
		response.sendRedirect("games");
	}

}
