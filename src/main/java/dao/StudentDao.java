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

}