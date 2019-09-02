package homePage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String user=request.getParameter("username");
		String sname=request.getParameter("name");
		String pass=request.getParameter("password");
		String realName=request.getParameter("flname");
		String age=request.getParameter("age");
		Properties prop=new Properties();
		DB db=new DB("app.properties");
			Connection con;
			try {
				db.connect();
				db.switchDatabase("imdb_games");
				con = DBConnection.getDBInstance(prop);
			
			String query="select username from users where username=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,user);
			ResultSet rs=ps.executeQuery();
			System.out.println(ps);
				//rs.next();
				//System.out.println(rs.getString(1));
				if(rs!=null &&rs.next() && !rs.getString(1).equals("")) {
					request.setAttribute("error", "already exists");
					RequestDispatcher rd=request.getRequestDispatcher("register1.jsp");
					rd.forward(request, response);
				}
				else {
					query="insert into users (username,password,gamertag,name,age) values(?,?,?,?,?)";
					ps=con.prepareStatement(query);
					ps.setString(1, user);
					ps.setString(2, pass);
					ps.setString(3, sname);
					ps.setString(4, realName);
					ps.setString(5, age);
					ps.executeUpdate();
					System.out.println(ps);
					request.setAttribute("uname", user);
					response.setContentType("text/html");
					RequestDispatcher rd=request.getRequestDispatcher("RegSuccess");
					rd.include(request, response);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//dbstuff
			
	//		rd.forward(request,response);
			//response.sendRedirect("RegSuccess");
	
		//doGet(request, response);
	}

}
