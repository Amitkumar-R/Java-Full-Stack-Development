package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmployeeBean;
import com.createread.EmployeeCreateRead;

/**
 * Servlet implementation class ServletRetrieve
 */
public class ServletRetrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRetrieve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<a href='index.html'>Add New Employee</a>");
		pw.println("<h1>Employee List</h1>");
		
		List<EmployeeBean> listEmp = EmployeeCreateRead.retrieve();
		pw.print("<table border='1' width='100%'>");
		pw.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th></tr>");
		
		for(EmployeeBean eb:listEmp) {
			pw.print("<tr><td>" + eb.getId() + "</td><td>" + eb.getName() +
					 "</td><td>"+ eb.getPassword() + "</td><td>" + eb.getEmail() + "</td></tr>");
		}
		pw.print("</table>");
	}

}
