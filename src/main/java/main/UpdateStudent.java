package main;

import java.util.Scanner;

import connection.DatabaseConnection;
import dao.StudentDao;
import entity.Student;

public class UpdateStudent {
	
	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao(DatabaseConnection.getConnection());
		
		

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter roll number for updating the student : ");
		int rollNo = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the first name : ");
		String firstName = sc.nextLine();
		
		System.out.println("Enter the last name : ");
		String lastName = sc.nextLine();
		
		System.out.println("Enter the email : ");
		String email = sc.nextLine();
		
		System.out.println("Enter the gender : ");
		String gender = sc.nextLine();
		
		Student student = new Student(rollNo,firstName, lastName, email, gender);
		
		studentDao.updateStudent(student);
	}

}
