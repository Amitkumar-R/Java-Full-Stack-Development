

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInterface
 */
public class ServletInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletConfig config = null;
	public void init(ServletConfig config) {
		this.config = config;
		System.out.println("Initialization completed...");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<body>");
		pw.print("The service() method<br>");
		pw.print("</body>");
		pw.print("</html>");
		
	}
	
	public void destroy() {
		System.out.println("This is the destroy() method");
	}
	
	public ServletConfig getServletConfig() {
		return config;
	}
	
	public String getServletInfo() {
		return "This is servlet interface";
	}

}
