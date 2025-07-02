package main;

import java.util.List;

import connection.DatabaseConnection;
import dao.StudentDao;
import entity.Student;

public class GetAllStudents {
	
	public static void main(String[] args) {
		
		
		StudentDao studentDao = new StudentDao(DatabaseConnection.getConnection());
		
		List<Student> students = studentDao.getAllStudents();
		
		for(Student s : students) {
			System.out.println(s);
		}
	}

}
