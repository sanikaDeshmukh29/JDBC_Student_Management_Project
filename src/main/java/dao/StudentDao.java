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

	public static Student updateStudent(Student student) {

		int rollNo = student.getRollNo();

		if (rollNo > 0) {

			String sql = "update student set firstName = ?, lastName = ?, email = ?, gender = ? where rollNo = ?";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, student.getFirstName());
				ps.setString(2, student.getlastName());
				ps.setString(3, student.getEmail());
				ps.setString(4, student.getGender());
				ps.setInt(5, rollNo);

				int result = ps.executeUpdate();

				if (result > 0) {

					System.out.println("Student updated successfully");
				} else {
					System.out.println("Failed to update");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return student;

	}

	public static void deleteStudent(int rollNo) {

		String sql = "delete from student where rollNo = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rollNo);

			int result = ps.executeUpdate();

			if (result > 0) {
				System.out.println("Student deleted successfully with roll number = " + rollNo);
			}

		} catch (SQLException e) {
			System.out.println("Roll number not found!");
			e.printStackTrace();
		}

	}

	public static List<Student> searchStudentByName(String name) {

		List<Student> students = new ArrayList<>();

		String sql = "select * from student where firstName Like ?";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + name + "%");

			ResultSet rs = ps.executeQuery();

			Student student = null;

			while (rs.next()) {
				student = new Student(

						rs.getInt("rollNo"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"),
						rs.getString("gender"), rs.getTimestamp("addDate").toLocalDateTime(),
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

	public static Student getStudent(int rollNo) {

		String sql = "select * from student where rollNo = ?";

		Student student = null;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, rollNo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				student = new Student(

						rs.getInt("rollNo"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"),
						rs.getString("gender"), rs.getTimestamp("addDate").toLocalDateTime(),
						rs.getTimestamp("lastUpdate").toLocalDateTime()

				);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(String.format("Student with roll number %d not found", rollNo));
		}

		return student;
	}

	public static List<Student> getRecordsPerPage(int limit, int offset) {

		List<Student> students = new ArrayList<Student>();

		String sql = "select * from student limit ? offset ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, limit);
			ps.setInt(2, offset);

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
