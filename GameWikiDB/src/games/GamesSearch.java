package games;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
 * Servlet implementation class GamesSearch
 */
@WebServlet("/GamesSearch")
public class GamesSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GamesSearch() {
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
            String name = request.getParameter("name");
            ArrayList<String> gameShit = null;
            ArrayList<ArrayList<String>> search = new ArrayList<ArrayList<String>>();
            String query = "select * from game";
            if(name!=null && !name.equals("")){
                query = "select * from game where name='" + name + "' ";
            }
            System.out.println("query " + query);
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                gameShit= new ArrayList<String>();

                gameShit.add(rs.getString(1));
                gameShit.add(rs.getString(2));
                gameShit.add(rs.getString(3));
                gameShit.add(rs.getString(4));
                gameShit.add(rs.getString(5));
                System.out.println("Games" + gameShit);
                search.add(gameShit);
            }

            request.setAttribute("Search", search);
            System.out.println("query " + query);
            RequestDispatcher results = request.getRequestDispatcher("SearchResults.jsp");
            results.forward(request, response);
	}	catch (Exception e) {
        e.printStackTrace();
	}

	}
}
