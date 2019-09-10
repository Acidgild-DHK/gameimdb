package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;

/**
 * Servlet implementation class GameRetriever
 */
@WebServlet("/game_retriever")
public class GameRetrieverService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameRetrieverService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gameId = request.getParameter("gameId");
		Object userObj = request.getSession().getAttribute("username");
		if (userObj == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		String username = userObj.toString();
		
		GameService gameServ = new GameService();
		Game game = gameServ.get(Integer.parseInt(gameId));
		System.out.println(game.getGameName());
		request.setAttribute("game", game);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
