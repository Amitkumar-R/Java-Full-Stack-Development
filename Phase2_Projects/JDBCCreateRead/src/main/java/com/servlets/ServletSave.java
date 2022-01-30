package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmployeeBean;
import com.createread.EmployeeCreateRead;

/**
 * Servlet implementation class ServletSave
 */
public class ServletSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletSave() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		EmployeeBean eb = new EmployeeBean();
		eb.setName(name);
		eb.setPassword(password);
		eb.setEmail(email);
		
		int status = EmployeeCreateRead.insert(eb);
		
		if(status > 0) {
			pw.print("Inserted Successfully!");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			pw.println("Insertion failed!");
		}
		pw.close();
				
	}

}
