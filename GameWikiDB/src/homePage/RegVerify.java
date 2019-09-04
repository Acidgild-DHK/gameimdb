package homePage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

/**
 * Servlet implementation class RegVerify
 */
@WebServlet("/RegVerify")
public class RegVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegVerify() {
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
		// TODO database again
		String user=request.getParameter("username").trim();
		String sname=request.getParameter("name").trim();
		String pass=request.getParameter("password").trim();
		String realName=request.getParameter("flname").trim();
		String age=request.getParameter("age").trim();
		Properties prop=new Properties();
		DB db=new DB("app.properties");
			Connection con;
			try {
				db.connect();
				db.switchDatabase("imdb_games");
				con = DBConnection.getDBInstance(prop);
			
			
				HashMap<String,String> hm=new HashMap<String,String>();
				hm.put("username",user);
				ResultSet rs=db.getData("users", hm);	
				if(rs!=null &&rs.next() && !rs.getString("username").equals("")) {
					request.setAttribute("error", "already exists");
					RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
					rd.forward(request, response);
				}
				else {
					String query="insert into users (username,password,gamertag,name,age) values('"+user+"','"+pass+"','"+sname+"','"+realName+"','"+age+"');";
					db.saveData(query);
					
					request.getSession().setAttribute("username",user);
					request.getSession().setAttribute("login", true);
					response.setContentType("text/html");
					RequestDispatcher rd=request.getRequestDispatcher("/user_logs");
					rd.include(request, response);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}

	}

}
