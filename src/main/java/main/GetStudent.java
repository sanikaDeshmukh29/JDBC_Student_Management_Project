package main;

import java.util.Scanner;

import connection.DatabaseConnection;
import dao.StudentDao;
import entity.Student;

public class GetStudent {
	
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao(DatabaseConnection.getConnection());
		
		//get student
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the roll number : ");
		int rollNo = sc.nextInt();
		
		Student student = studentDao.getStudent(rollNo);
		
		System.out.println(student);
	}

}
