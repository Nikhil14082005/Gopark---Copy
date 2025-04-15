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
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payment() {
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
		String cno=request.getParameter("card_number");
		String ctype=request.getParameter("card_type");
		String date=request.getParameter("exp_date");
		int cvv=Integer.parseInt(request.getParameter("cvv"));
		
		   System.out.println(name);
		    System.out.println(cno);
		    System.out.println(ctype);
		    System.out.println(date);
		    System.out.println(cvv);
		    
		
		try {
		
			PreparedStatement pstmt=con.prepareStatement("insert into checkout values(?,?,?,?,?)");
		   
		    pstmt.setString(1, name);
		    pstmt.setString(2, cno);
		    pstmt.setString(3, ctype);
		    pstmt.setString(4,date);
		    pstmt.setInt(5,cvv);
		    
		    
		 
		    int i=	pstmt.executeUpdate();
		if(i>0)
		{
			response.sendRedirect("qr.html");
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