package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconnection.DBConnection;
import com.mysql.cj.jdbc.CallableStatement;

/**
 * Servlet implementation class JDBCStoredServlet
 */
public class JDBCStoredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public JDBCStoredServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		
		try {
			Connection conn = DBConnection.dbConn();
			CallableStatement cs = (CallableStatement) conn.createStatement().getConnection().prepareCall("{call add_emp(?,?)}");
			cs.setString(1, "new product");
			cs.setInt(2, new Integer(2));
			cs.executeUpdate();
			
			pw.println("Stored procedure has been exceuted.<br>");
			pw.close();
			
			pw.println("</body></html>");
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
