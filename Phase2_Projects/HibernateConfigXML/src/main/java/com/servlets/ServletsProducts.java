package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bean.EProductBean;
import com.util.HibernateUtil;

/**
 * Servlet implementation class ServletsProducts
 */
public class ServletsProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletsProducts() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		try {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			List<EProductBean> list = s.createQuery("form eproduct").list();
			s.close();
			
			pw.println("<html><body>");
			pw.println("<b>Product List</b><br/>");
			for(EProductBean p : list) {
				pw.println("ID: " + String.valueOf(p.getId()) + ", Name: " + p.getName()
				+ ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");
			}
			pw.println("</body></html>");
			
		} catch(Exception e) {
			pw.print(e);
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
