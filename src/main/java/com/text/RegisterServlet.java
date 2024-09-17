package com.text;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doa.text.Connectiondoa;

public class RegisterServlet extends HttpServlet{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connectiondoa connectiondoa;
	public RegisterServlet() {
		super();
		connectiondoa = new Connectiondoa();
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String gender = req.getParameter("gender");
		String department = req.getParameter("department");
		String branch = req.getParameter("branch");
		String contact = req.getParameter("contact");
		String password = req.getParameter("password");
		
		try {
			connectiondoa.Saveuser(name, email, address, gender, department, branch, contact, password);
			//out.println("registration sucessfully");
			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}

