package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connection.DatabaseConnection;
import dao.StudentDao;
import entity.Student;

public class SearchStudentByName {
	
	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao(DatabaseConnection.getConnection());
		
		//search by name
		
		List<Student> students = new ArrayList<Student>();
		
		System.out.println("Enter the name to search the student : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		students = studentDao.searchStudentByName(name);
		
		for(Student s : students) {
			System.out.println(s);
		}
		
		
	}

}
