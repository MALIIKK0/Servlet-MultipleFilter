

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/hello")
public class LogFilter extends HttpFilter implements Filter {
       
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out
        .println("------------------------------------------------------");
		System.out.println(" init method is called in "
		        + this.getClass().getName());
		System.out
		        .println("------------------------------------------------------");
			}


 		

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out
        .println("------------------------------------------------------");
		System.out.println(" doFilter method is called in "
		        + this.getClass().getName());
		System.out
        .println("------------------------------------------------------");
		
		
		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request;
		
		String ipAddress = req.getRemoteAddr();
		System.out.println("IP" +ipAddress + "Time" + new Date().toString() );
		
		// pass the request along the filter chain
		out.print("LogFilter is invoked before<br>");
		
		chain.doFilter(request, response);
		
		out.print("LogFilter is invoked After<br>");

	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out
        .println("------------------------------------------------------");
		System.out.println(" destroy method is called in "
		        + this.getClass().getName());
		System.out
		        .println("------------------------------------------------------");
	}
	
	

}
