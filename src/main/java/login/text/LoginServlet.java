package login.text;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if(validateuser(email,password)) {
			
			HttpSession ses = req.getSession();
			ses.setAttribute("name", email);
			
			
//			resp.sendRedirect(req.getContextPath() + "/ProfileServlet");

			RequestDispatcher rd = req.getRequestDispatcher("logout.html");
			rd.forward(req, resp);
//			out.print("login sucessfully");
		}else {
			out.print("login not sucessfully");
		}
	}

	    
    private boolean validateuser(String email,String password) {
		boolean br = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/puja2","root","Puja2002");
			
			String sql = "SELECT * FROM register WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rss =  ps.executeQuery();
			
			if(((ResultSet) rss).next()) {
				br = true;
			}
			((PrintWriter) rss).close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return br;
	}

}
