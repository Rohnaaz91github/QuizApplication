package com.quiz.velocity.student.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentLoginDemo implements StudentLoginConsole {
	
     /*here we took boolean method to verify username and password
      * which already store in database at the time of student registration
      */
      //this method return true and false value
	public boolean loginStudent() throws SQLException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your Username: ");
		String username = scanner.nextLine();

		System.out.print("Enter your password: ");
		String password = scanner.nextLine();

		Connection conn = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/quizapplication", "root", "Rohnaaz91@");

			ps2 = conn.prepareStatement("SELECT * FROM studentdetails WHERE username = ? AND password = ?");
			ps2.setString(1, username);
			ps2.setString(2, password);
			rs2 = ps2.executeQuery();

			if (rs2.next()) {
				String name = rs2.getString("Username");
				System.out.println("Welcome, " + username + "!");
				return true;
			} else {
				System.out.println("Invalid email or password. Please try again.");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			conn.close();
			ps2.close();
			rs2.close();
		}
		return false;
	}

	//here we call the boolean method in override method 
	@Override
	public void StudentLoginDetails() {
		try {
			StudentLoginDemo sl = new StudentLoginDemo();
			boolean loginSuccessful = sl.loginStudent();
			if (loginSuccessful) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
