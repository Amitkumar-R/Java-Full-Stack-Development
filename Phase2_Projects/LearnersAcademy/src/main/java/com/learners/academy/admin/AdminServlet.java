package com.learners.academy.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.learners.academy.models.Student;
import com.learners.academy.models.Subject;
import com.learners.academy.models.Teacher;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DbRetrieve dbr;
	private DataSource ds;
	
	public void init() throws ServletException {
		super.init();
		try {
			dbr = new DbRetrieve(ds);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String c = request.getParameter("command");
			
			if(c == null) {
				c = "CLASSES";
			}
			
			if(!getCookies(request, response) && (!c.equals("LOGIN"))) {
				response.sendRedirect("login.jsp");
			} else {
				
				switch(c) {

				case "STUDENTS":
					studentsList(request, response);
					break;

				case "TEACHERS":
					teachersList(request, response);
					break;

				case "SUBJECTS":
					subjectList(request, response);
					break;

				case "CLASSES":
					classestList(request, response);
					break;

				case "ST_LIST":
					classStudentsList(request, response);
					break;

				case "LOGIN":
					login(request, response);
					break;

				default:
					classestList(request, response);

				}
			}
			
			
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {

			Cookie cookie = new Cookie(username, password);

			// Setting the maximum age to 1 day
			cookie.setMaxAge(86400); // 86400 seconds in a day

			// Send the cookie to the client
			response.addCookie(cookie);
			classestList(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void studentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Student> studs = dbr.getStudents();
		request.setAttribute("STUDENT_LIST", studs);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentsList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void teachersList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Teacher> teachers = dbr.getTeachers();
		request.setAttribute("TEACHERS_LIST", teachers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("teachersList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void subjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Subject> subs = dbr.getSubjects();
		request.setAttribute("SUBJECTS_LIST", subs);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectsList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void classestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Class> classes = dbr.getClasses();
		request.setAttribute("CLASSES_LIST", classes);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("classesList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void classStudentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int classId = Integer.parseInt(request.getParameter("classId"));
		String section = request.getParameter("section");
		String subject = request.getParameter("subject");

		// get subjects from db util
		List<Student> students = dbr.loadClassStudents(classId);

		// add subjects to the request
		request.setAttribute("STUDENTS_LIST", students);
		request.setAttribute("SECTION", section);
		request.setAttribute("SUBJECT", subject);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("classStudents.jsp");
		dispatcher.forward(request, response);
	}

	private boolean getCookies(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		boolean check = false;
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("admin") && cookie.getValue().equals("admin")); {
				check = true;
				break;
			}
		}
		return check;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
