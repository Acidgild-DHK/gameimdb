package games;


import java.io.IOException;
import java.sql.Connection;
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

import db.DB;
import db.DBConnection;
import db.DBExceptions;

/**
 * Servlet implementation class GamesUpdate
 */
@WebServlet("/GameUpdate")
public class GamesUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GamesUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    DB db =null;
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
		db = new DB("app.properties");
		Properties prop=new Properties();
		String name = request.getParameter("name");
		ArrayList<String> gameS= new ArrayList<String>();

		String query = "INSERT INTO 'imdb_games'.'games' ('name') VALUES (?)";
		Connection con;
        Statement st=null;
		try {
			db.connect();
			db.switchDatabase("imdb_games");
			con = DBConnection.getDBInstance(prop);
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			gameS.add(name);
			request.setAttribute("gameS", gameS);
			RequestDispatcher results = request.getRequestDispatcher("/GameUpdate.jsp");
			results.forward(request, response);
		} catch (DBExceptions | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
