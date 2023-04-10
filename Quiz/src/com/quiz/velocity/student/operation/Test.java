package com.quiz.velocity.student.operation;

import java.sql.SQLException;
import java.util.Scanner;

import com.quiz.velocity.admin.operation.AdminOperationDemo;

public class Test {

	public static void main(String args[]) throws SQLException {

		System.out.println("                                  ");
		System.out.println("Welcome to Quiz based application");
		System.out.println("                                  ");
		System.out.println("User Operation");
		System.out.println("                                  ");
		System.out.println("1. Student Registration");
		System.out.println("                                  ");
		System.out.println("2. Student Login");
		System.out.println("                                  ");
		System.out.println("3. Display the list of questions");
		System.out.println("                                  ");
		System.out.println("4. Display Quiz result");
		System.out.println("                                  ");
		System.out.println("Admin Operation");
		System.out.println("                                  ");
		System.out.println("5. Display all students score as per ascending order");
		System.out.println("                                  ");
		System.out.println("6. Fetch student score by using id");
		System.out.println("                                  ");
		System.out.println("7. Add question with 4 options into database");
		System.out.println("                                  ");
        System.out.println("Enter Your Choice");
		
		
		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			StudentRegisterDemo studentRegisterDemo = new StudentRegisterDemo();
			studentRegisterDemo.getStudentDetails();
			break;
		case 2:
			StudentLoginDemo studentLoginDemo = new StudentLoginDemo();
			studentLoginDemo.loginStudent();
			studentLoginDemo.StudentLoginDetails();

			break;
		case 3:
			DisplayQuestionDemo displayQuestionDemo = new DisplayQuestionDemo();
			displayQuestionDemo.getDisplayQuestion();
			displayQuestionDemo.getDisplay();
			break;
		case 4:
			StudentScoreDemo studentScoreDemo = new StudentScoreDemo();
			studentScoreDemo.getStudentScoreDetails();
			break;
		case 5:
			AdminOperationDemo adminOperationDemo = new AdminOperationDemo();
			adminOperationDemo.displayAllScoresAscending();
			break;
		case 6:
			AdminOperationDemo adminOperationDemo1 = new AdminOperationDemo();
			adminOperationDemo1.fetchStudentScoreById();
			break;
		case 7:
			AdminOperationDemo adminOperationDemo2 = new AdminOperationDemo();
			adminOperationDemo2.addQuestionWithOptions();
			break;
		default:
			System.out.println("Invalid Input");

		}
	}

}
