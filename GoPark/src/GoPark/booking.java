package GoPark;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signin
 */
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booking() {
        super();
        // TODO Auto-generated constructor stub
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
		doGet(request, response);
		
		Connection con=database.connect();
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String pspot=request.getParameter("parking_place");	
		String date=request.getParameter("date");
		String spots=request.getParameter("spots");
		String etime=request.getParameter("entry-time");
		String ltime=request.getParameter("leaving-time");
		   System.out.println(city);
		    System.out.println(pspot);
		    System.out.println(name);
		    System.out.println(date);
		    System.out.println(etime);
		    System.out.println(ltime);
		
		try {
		
			PreparedStatement pstmt=con.prepareStatement("insert into booking values(?,?,?,?,?,?,?)");
			pstmt.setString(1, name);
		    pstmt.setString(2, city);
		    pstmt.setString(3, pspot);
		    pstmt.setString(4, date);
		    pstmt.setString(5, spots);
		    pstmt.setString(6,etime);
		    pstmt.setString(7, ltime);
		    
		 
		    int i=	pstmt.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("payment.html");
			System.out.println("Login successful");
		}else
		{
			response.sendRedirect("404.html");
			System.out.println("Login Failed");
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}