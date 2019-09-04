package games;

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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DB;
import db.DBConnection;


/**
 * Servlet implementation class GameInfo
 */
@WebServlet("/GameInfo")
public class GamesTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GamesTable() {

        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Properties prop=new Properties();
		DB db=new DB("app.properties");
		Connection con;
        Statement st=null;
        try {
        	db.connect();
        	db.switchDatabase("imdb_games");
        	con = DBConnection.getDBInstance(prop);
            System.out.println("connected!.....");
            ArrayList<String> gt = null;
            String query = "select * from game";
            System.out.println("query " + query);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                gt= new ArrayList<String>();
                gt.add(rs.getString(1));
                gt.add(rs.getString(2));
                gt.add(rs.getString(3));
                gt.add(rs.getString(4));
                gt.add(rs.getString(5));
                System.out.println("Games" + gt);
      			}} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}

	

}}
