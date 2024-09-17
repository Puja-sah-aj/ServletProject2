package filter.com;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/submit")
public class RegisterFilter implements Filter{
	
	private Pattern emailpattern;
	private Pattern  passwordPattern;
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		emailpattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
		passwordPattern = Pattern.compile("^(?=.[A-Z])(?=.[!@#$%^&])[A-Za-z0-9!@#$%^&]{1,8}$");
	}

			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				// TODO Auto-generated method stub
				
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		if(email !=null && emailpattern.matcher(email).matches()) {
			if(password != null && passwordPattern.matcher(password).matches()) {
				
				chain.doFilter(request, response);	
			}
			else {
				System.out.println("invalid password");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			}
			
		}
		else {
			System.out.println("invalid email format");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			
			
   }
				
		
	}
	

}
