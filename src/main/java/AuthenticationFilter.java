import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebFilter("/hello")
public class AuthenticationFilter implements Filter
{

		public void init( FilterConfig config ) throws ServletException
		{
				System.out.println("------------------------------------------------------");
				System.out.println(" init method is called in "
				                + this.getClass().getName());
				System.out.println("------------------------------------------------------");
		}

		public void doFilter( ServletRequest request, ServletResponse response,
		                FilterChain chain ) throws IOException,
		                ServletException
		{

				System.out.println(" doFilter method is called in "
				                + this.getClass().getName()+"\n\n");
				
				PrintWriter out = response.getWriter();
				
				HttpServletRequest req = (HttpServletRequest) request;
				HttpServletResponse res= (HttpServletResponse) response;

				String username = request.getParameter("username");
				String password = request.getParameter("password");
				if( username != null && password != null && username.equals("admin") && password.equals("admin") )
				{
						// sends request to next resource
						chain.doFilter(request, response);
				}
				else
				{
					System.out.println("===========================");
					System.out.println("Unauthorized request");
					System.out.println("====================");
					res.sendRedirect("index.html");
					
				}
		}

		public void destroy()
		{
				// add code to release any resource
				System.out.println("------------------------------------------------------");
				System.out.println(" destroy method is called in "
				                + this.getClass().getName());
				System.out.println("------------------------------------------------------");
		}
}