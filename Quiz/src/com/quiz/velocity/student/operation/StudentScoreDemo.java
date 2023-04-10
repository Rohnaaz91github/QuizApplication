package com.quiz.velocity.student.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentScoreDemo implements StudentScore{

	@Override
	public void getStudentScoreDetails() throws SQLException {
		
		//by entering email is student will get his score
		//this is for future reference
		System.out.print("Enter email: ");
		Scanner sc1 = new Scanner(System.in);
		String mailid = sc1.nextLine();
         //sc1.nextLine() with this method we scan user email id and fetch his score
		/*String mailid dont forget take same variable with match with database 
		column to store user input*/
		
		Connection connec = null;
		PreparedStatement ps3 = null;
		ResultSet rs3 = null;
		try {
          //loading connection
			Class.forName("com.mysql.jdbc.Driver");
          //established connection with database
			connec = DriverManager.getConnection("jdbc:mysql://localhost/quizapplication", "root", "Rohnaaz91@");
         // prepared statement to get data from database
			ps3 = connec.prepareStatement("SELECT score FROM studentdetails WHERE mailid=?");
			ps3.setString(1, mailid);

			rs3 = ps3.executeQuery();

			if (rs3.next()) {
				int score = rs3.getInt("score");
				System.out.println("Quiz score for " + mailid + ": " + score);
			} else {
				System.out.println("No quiz score found for " + mailid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connec.close();
			ps3.close();
			rs3.close();
		}

	}
		
	}


