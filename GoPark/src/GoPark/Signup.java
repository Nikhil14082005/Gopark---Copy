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
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Signup() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = database.connect();  // Ensure this method is correctly implemented

            String name = request.getParameter("Name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String city = request.getParameter("city");
            String password = request.getParameter("Password"); // Change from int to String

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("City: " + city);
            System.out.println("Password: " + password);

            String query = "INSERT INTO signup (name, email, phone, city, password) VALUES (?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, city);
            pstmt.setString(5, password); // Storing password as plain text is not recommended

            int i = pstmt.executeUpdate();

            if (i > 0) {
                response.sendRedirect("login.html");
                System.out.println("Signup successful");
            } else {
                response.sendRedirect("signup.html");
                System.out.println("Signup failed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
