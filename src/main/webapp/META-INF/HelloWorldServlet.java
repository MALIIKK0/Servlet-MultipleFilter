

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet(description = "printing hello world", urlPatterns = { "/hello" })
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	public void init() throws ServletException 
	{
		System.out.println("-------------------------------------");
		System.out.println("Init method is called in" + this.getClass().getName()  );
		System.out.println("-------------------------------------");

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out
	        .println("------------------------------------------------------");
			System.out.println(" doGet is called in "
			        + this.getClass().getName());
			System.out
			        .println("------------------------------------------------------");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.print("<h1>Hello World IGL4</h1><br>");
					
	}
	public void destroy()
	{
		System.out
		        .println("------------------------------------------------------");
		System.out.println(" destroy method is called in "
		        + this.getClass().getName());
		System.out
		        .println("------------------------------------------------------");
	}

}
