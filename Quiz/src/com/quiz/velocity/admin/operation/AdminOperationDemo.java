package com.quiz.velocity.admin.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminOperationDemo implements AdminOperation {
	//here connection class declare globally because in this program we
	//implement three method and each method working base on connection to 
	//connect database
	//also we declare scanner class globally because every method working
	//base on scanner class to scan user input
	 public Connection connection;
	    public Scanner scanner;

	    public AdminOperationDemo() throws SQLException {
	    	
	    	//here we took constructor to loading connection
	    	//and established connection with database 
	    	//to fetch and store the data into database
	    	
	    	
	    	try{
	    		Class.forName("com.mysql.jdbc.Driver");
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	        connection = DriverManager.getConnection("jdbc:mysql://localhost/quizapplication", "root", "Rohnaaz91@");
	        scanner = new Scanner(System.in);
	    }

	@Override
	public void displayAllScoresAscending() throws SQLException {
		
		Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("SELECT score FROM studentscore ORDER BY score ASC");

        System.out.println("All student scores in ascending order:");
        while (resultSet.next()) {
            
            int score = resultSet.getInt("score");
            System.out.println(" >>>>> " + score);
        }
		
	}

	@Override
	public void fetchStudentScoreById() throws SQLException {
		
		System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        
        PreparedStatement ps4 = connection.prepareStatement("SELECT score FROM studentscore WHERE student_id=?");
        ps4.setInt(1, id);

        ResultSet rs4 = ps4.executeQuery();
        
        //here we used if block to get score by entering student id
        //if id will not exist this method return false value
        if (rs4.next()) {
            
            int score = rs4.getInt("score");
            System.out.println("Quiz score for ID " + id + " : " + score);
        } else {
            System.out.println("No quiz score found for ID " + id);
        }
    }
	

	@Override
	public void addQuestionWithOptions() throws SQLException {
		

        System.out.print("Enter question : ");
        String question = scanner.nextLine();

        System.out.print("Enter option 1 : ");
        String option1 = scanner.nextLine();

        System.out.print("Enter option 2 : ");
        String option2 = scanner.nextLine();

        System.out.print("Enter option 3 : ");
        String option3 = scanner.nextLine();

        System.out.print("Enter option 4 : ");
        String option4 = scanner.nextLine();

        System.out.print("Enter correct answer (1-4) : ");
        int answer = scanner.nextInt();

        String query = "INSERT INTO questiontable (question, option1, option2, option3, option4, answer) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps5 = connection.prepareStatement(query);
        ps5.setString(1, question);
        ps5.setString(2, option1);
        ps5.setString(3, option2);
        ps5.setString(4, option3);
        ps5.setString(5, option4);
        ps5.setInt(6, answer);

        int rows = ps5.executeUpdate();
        if (rows > 0) {
            System.out.println("Question added successfully");
        } else {
            System.out.println("Failed to add question");
        }
        
    
		
	}

}
