package com.jsp.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.student.connection.Student_Connection;
import com.jsp.student.dto.Student;

public class StudentDao {

	Connection connection = Student_Connection.getStudentConnection();

	public Student insertRecord(Student student) {

		String insertQuery = "INSERT INTO Student (Id, Name, Email, Phone, Degree, Branch, Gender, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getPhone());
			ps.setString(5, student.getDegree());
			ps.setString(6, student.getBranch());
			ps.setString(7, student.getGender());
			ps.setString(8, student.getPassword());

			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Data inserted successfully");
				return student;
			} else {
				System.out.println("Failed to insert data");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Student getLoginDeatilsDao(String userEmail) {
		String slectQry = "Select * from Student where email=?";

		try {
			PreparedStatement ps = connection.prepareStatement(slectQry);
			ps.setString(1, userEmail);

			ResultSet resultSet = ps.executeQuery();
			resultSet.next();
			String email = resultSet.getString("email");
			String password = resultSet.getString("password");

			Student student = new Student(email, password);

			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public List<Student> getAllDetails() {
		String slectQry = "Select * from Student";
		try {
			PreparedStatement ps = connection.prepareStatement(slectQry);
			ResultSet result = ps.executeQuery();
			List<Student> students = new ArrayList<>();
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("Name");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String degree = result.getString("degree");
				String branch = result.getString("branch");
				String gender = result.getString("gender");
				String password = result.getString("password");

				Student s = new Student(id, name, email, phone, degree, branch, gender, password);
				students.add(s);

			}
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public void deleteStudentRecord(int id) {
		String deleteQry = "delete from Student where Id =?";
		try {
			PreparedStatement ps = connection.prepareStatement(deleteQry);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println(" Data is Deleted From Database");
			} else {
				System.out.println(" Data is Not Deleted From Database");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Student getAllDetails(int stuId) {
		String selectQry = "Select * from Student where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(selectQry);
			ps.setInt(1, stuId);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("Name");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String degree = result.getString("degree");
				String branch = result.getString("branch");
				String gender = result.getString("gender");
				String password = result.getString("password");

				Student s = new Student(id, name, email, phone, degree, branch, gender, password);

				return s;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;

	}

	public void updateStudentByEmail(Student student) {
	    try {
	        String query = "UPDATE student SET id=?, name=?, phone=?, degree=?, branch=?, gender=?, password=? WHERE email=?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, student.getId());
	        preparedStatement.setString(2, student.getName());
	        preparedStatement.setString(3, student.getPhone());
	        preparedStatement.setString(4, student.getDegree());
	        preparedStatement.setString(5, student.getBranch());
	        preparedStatement.setString(6, student.getGender());
	        preparedStatement.setString(7, student.getPassword());
	        preparedStatement.setString(8, student.getEmail());
	        preparedStatement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
public  Student getNameBySessionAttributes(String email) {
	String selectqQry="select name from student where email =?";
	try {
		PreparedStatement preparedStatement=connection.prepareStatement(selectqQry);
		preparedStatement.setString(1, email);
		ResultSet resultSet=preparedStatement.executeQuery();
		
		resultSet.next();
		String name = resultSet.getString("name");
		
		Student student=new Student(name);
		return student;

		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
	
}

}
