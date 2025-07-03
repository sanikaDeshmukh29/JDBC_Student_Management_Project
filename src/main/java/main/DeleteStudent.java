package main;

import java.util.Scanner;

import connection.DatabaseConnection;
import dao.StudentDao;

public class DeleteStudent {
	
	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao(DatabaseConnection.getConnection());
		
		// deleting the student
		
		System.out.println("enter roll number to delete student");
		Scanner sc = new Scanner(System.in);
		
		int rollNo = sc.nextInt();
		
		studentDao.deleteStudent(rollNo);
	}

}
