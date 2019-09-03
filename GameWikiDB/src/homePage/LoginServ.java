package homePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DB;
import db.DBConnection;
import db.DBExceptions;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO add database connectivity in if statement checking
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		Properties prop=new Properties();
		
		DB db=new DB("app.properties");
			Connection con;
			try {
				db.connect();
				db.switchDatabase("imdb_games");
				con = DBConnection.getDBInstance(prop);
			
			//String query="select password from users where username=?";
			HashMap<String,String> hm=new HashMap<String,String>();
			hm.put("username",uname);
			ResultSet rs=db.getData("users", hm);
			//PreparedStatement ps=con.prepareStatement(query);
			//ps.setString(1,uname);
			//ResultSet rs=ps.executeQuery();
			
			if(rs==null) {
				request.setAttribute("error", "no user");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else {
				rs.next();
			}
			if(pass.equals(rs.getString("password"))) {
				System.out.println(uname+" "+true);
				//HttpSession ses=request.getSession();
				//ses.setAttribute("uname", uname);
				//ses.setAttribute("login", true);
				request.getSession().setAttribute("uname",uname);
				request.getSession().setAttribute("login", true);
				RequestDispatcher rd=request.getRequestDispatcher("LoginSuccess");
				rd.forward(request,response);
			}
			else {
				request.setAttribute("error", "failed");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			} catch (DBExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
