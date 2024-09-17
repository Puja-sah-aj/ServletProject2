package doa.text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connectiondoa {
	public Connectiondoa() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/puja2","root","Puja2002");
	}
	public void Saveuser(String name,String email,String address,String gender,String department,String branch,String contact,String password) {
		String sql = "insert into register(name,email,address,gender,department,branch,contact,password) values(?,?,?,?,?,?,?,?)";
		
		try {
			Connection conn = getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, email);
			pre.setString(3, address);
			pre.setString(4, gender);
			pre.setString(5, department);
			pre.setString(6, branch);
			pre.setString(7, contact);
			pre.setString(8, password);
			
			int i = pre.executeUpdate();
			if(i > 0) {
				System.out.println("register successfully");
			}
			else {
				System.out.println("register not sucessfully");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
//	public static void main(String [] arr) {
//		Connectiondoa cb = new Connectiondoa();
//		String name = "sonu";
//		String email ="sonu457@gmail.com";
//		String address = "noida";
//		String gender = "male";
//		String department = "B.tech";
//		String branch = "cse";
//		String contact = "1234567890";
//		String password = "12245";
//		
	//	cb.Saveuser(name, email, address, gender, department, branch, contact, password);
		
	//}

}
