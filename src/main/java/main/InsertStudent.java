package main;

import java.util.Scanner;

import connection.DatabaseConnection;
import dao.StudentDao;
import entity.Student;

public class InsertStudent {
	
	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao(DatabaseConnection.getConnection());
		
		// inserting student
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first name : ");
		String firstName = sc.nextLine();
		
		System.out.println("Enter the last name : ");
		String lastName = sc.nextLine();
		
		System.out.println("Enter the email : ");
		String email = sc.nextLine();
		
		System.out.println("Enter the gender : ");
		String gender = sc.nextLine();
		
		Student student = new Student(firstName, lastName, email, gender);
		
		studentDao.insertStudent(student);

	}
}
