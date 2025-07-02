package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import connection.DatabaseConnection;
import entity.Student;

public class StudentDao {

	static Connection conn = DatabaseConnection.getConnection();

	public StudentDao(Connection conn) {

		this.conn = conn;
	}
	
	
	public static void insertStudent(Student student) {

		String sql = "Insert into student(firstName, lastName, email, gender) values (?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getlastName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getGender());

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println("Student inserted Successfully!");
			} else {
				System.out.println("Fialed to insert student!");
			}

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("email already exsist!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		String sql = "select * from student";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Student student = new Student(rs.getInt("rollNo"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("email"), rs.getString("gender"), rs.getTimestamp("addDate").toLocalDateTime(),
						rs.getTimestamp("lastUpdate").toLocalDateTime()

				);

				students.add(student);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return students;

	}


}

