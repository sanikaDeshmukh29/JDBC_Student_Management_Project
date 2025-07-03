package main;

import java.util.List;
import java.util.Scanner;

import connection.DatabaseConnection;
import dao.StudentDao;
import entity.Student;

public class GetRecordsPerPage {

	public static void main(String[] args) {

		StudentDao studentDao = new StudentDao(DatabaseConnection.getConnection());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the page number");
		int page = sc.nextInt();
		int limit = 5;

		int offset = (page - 1) * limit;

		List<Student> students = StudentDao.getRecordsPerPage(limit, offset);
		for (Student s : students) {
		    System.out.println(s);
		}
			
	}

}
