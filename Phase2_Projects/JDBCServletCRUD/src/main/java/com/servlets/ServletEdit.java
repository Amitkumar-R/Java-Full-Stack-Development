package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.EmployeeBean;
import com.crud.EmployeeCRUD;

/**
 * Servlet implementation class ServletEdit
 */
public class ServletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		EmployeeBean eb = new EmployeeBean();
		eb.setId(id);
		eb.setName(name);
		eb.setPassword(password);
		eb.setEmail(email);
		
		int status = EmployeeCRUD.edit(eb);
		if(status > 0) {
			response.sendRedirect("index.html");
		} else {
			pw.println("Updation failed!");
		}
		pw.close();		
	}

}
