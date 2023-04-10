package com.quiz.velocity.student.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRegisterDemo implements StudentRegistrationConsole {

	// here we override getStudentDetails from interface

	@Override
	public void getStudentDetails() throws SQLException {

		// we took scanner class for user input to fill the registration details

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter First name: ");
		String firstname = scanner.nextLine();

		System.out.println("Enter Last name: ");
		String lastname = scanner.nextLine();

		System.out.println("Enter User name: ");
		String username = scanner.nextLine();

		System.out.println("Enter your password: ");
		String password = scanner.nextLine();

		System.out.println("Enter your city: ");
		String city = scanner.nextLine();

		System.out.println("Enter your email: ");
		String mailid = scanner.nextLine();

		System.out.println("Enter your Mobilenumber: ");
		String mobilenumber = scanner.nextLine();

		System.out.println("First name : " + firstname);
		System.out.println("Last name : " + lastname);
		System.out.println("User name : " + username);
		System.out.println("Password : " + password);
		System.out.println("City : " + city);
		System.out.println("Email : " + mailid);
		System.out.println("MobileNumber : " + mobilenumber);

		Connection con = null;
		PreparedStatement ps = null;
		try {
			// step 1 loading connection
			Class.forName("com.mysql.jdbc.Driver");

			/*
			 * step 2 established connection with database to store information which is
			 * taken from user
			 */
			con = DriverManager.getConnection("jdbc:mysql://localhost/quizapplication", "root", "Rohnaaz91@");
            // step 3 took prepared statement to insert data into through this we insert data into table 
			ps = con.prepareStatement(
					"insert into studentdetails (firstname,lastname,username,password,city,mailid,mobilenumber ) VALUES "
							+ "(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, city);
			ps.setString(6, mailid);
			ps.setString(7, mobilenumber);
			int a = ps.executeUpdate();
			System.out.println("Record inserted successfully : " + a);
			System.out.println("Registration successful!");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
		}

	}

}
