package com.learners.academy.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DataSource dataSource;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set the printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		// establish connection to the DB
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			myConn = dataSource.getConnection();
			//create a sql statement
			String sql = "select * from students";
			myStmt = myConn.createStatement();


			//execute the sql statement
			myRs = myStmt.executeQuery(sql);

			//process the resultset
			while(myRs.next()) {
				String fname = myRs.getString("fname");
				out.println(fname);

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
