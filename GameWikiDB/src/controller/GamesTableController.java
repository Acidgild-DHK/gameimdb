package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Game;
import model.Log;


/**
 * Servlet implementation class GameInfo
 */
@WebServlet("/games")
public class GamesTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GamesTableController() {

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		ArrayList<Game> games = gUtil.getGameTable("<form action='userLogUpdate.jsp'>"
//				+ "<input type='hidden' value='{{gameID}}' name='gameID'>"
//				+ "<input type='submit' value='update'>"
//				+ "</form>");
//		
//		session.setAttribute("gameTable", games);
//		
//		RequestDispatcher dispatch = request.getRequestDispatcher("/games.jsp");
//		dispatch.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		Properties prop=new Properties();
//		DB db=new DB("app.properties");
//		Connection con;
//        Statement st=null;
//        try {
//        	db.connect();
//        	db.switchDatabase("imdb_games");
//        	con = DBConnection.getDBInstance(prop);
//            System.out.println("connected!.....");
//            ArrayList<String> gt = null;
//            String query = "select * from game";
//            st = con.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            ArrayList<ArrayList<String>> gTable = new ArrayList<ArrayList<String>>();
//            while (rs.next()) {
//                gt = new ArrayList<String>();
//                gt.add(rs.getString(1));
//                gt.add(rs.getString(2));
//                gt.add(rs.getString(3));
//                gt.add(rs.getString(4));
//                gt.add(rs.getString(5));
//                gt.add(rs.getString(6));
//                gt.add(rs.getString(7));
//                gt.add(rs.getString(8));
//                System.out.println("Games" + gt);
//                gTable.add(gt);
//            }
//            	System.out.println("gTable " + gTable);
//            	request.setAttribute("gTable", gTable);
//            	RequestDispatcher results = request.getRequestDispatcher("/GameTable.jsp");
//                results.forward(request, response);
//      			} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}catch (Exception e) {
//		e.printStackTrace();
//	}
	

}}
