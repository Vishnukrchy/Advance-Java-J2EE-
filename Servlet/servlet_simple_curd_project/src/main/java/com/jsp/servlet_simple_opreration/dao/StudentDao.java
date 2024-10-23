package com.jsp.servlet_simple_opreration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.servlet_simple_opreration.connection.StudentConnection;
import com.jsp.servlet_simple_opreration.dto.Student;

public class StudentDao {
	static Connection connection = StudentConnection.geStudentConnection();
//	static Scanner sc = new Scanner(System.in);

	public Student insertRecord(Student s) {

		String insertQry = "Insert Into Student(Name,Email,Phone,degree,branch,gender,password) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(insertQry);

			System.out.println(" inserted Value is " + s);

			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPhone());
			ps.setString(4, s.getDegree());
			ps.setString(5, s.getBranch());
			ps.setString(6, s.getGender());
			ps.setString(7, s.getPassword());

			ps.execute();
			System.out.println("Data is inersted Sucessfully");

			return s;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Student fetchStudentemailForLoginDao(String userEmail) {
		String getQry = "select * from student where email=?";
		try {
			PreparedStatement ps = connection.prepareStatement(getQry);
			ps.setString(1, userEmail);
			ResultSet result = ps.executeQuery();
			result.next();

//			String email = result.getString("email");
//			String password = result.getString("password");
//			Student s = new Student(email, password);
//			return s;

			return new Student(result.getString("email"), result.getString("password"));

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
				String name = result.getString("Name");
				String email = result.getString("email");
				String phone = result.getString("phone");
				String degree = result.getString("degree");
				String branch = result.getString("branch");
				String gender = result.getString("gender");
				String password = result.getString("password");

				Student s = new Student(name, email, phone, degree, branch, gender, password);
				students.add(s);

			}
			return students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static Student getStudentSetailsByEmail(String email) {
		String selectQry ="Select * from Student where email=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(selectQry);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				String name = result.getString("Name");
				String email1 = result.getString("email");
				String phone = result.getString("phone");
				String degree = result.getString("degree");
				String branch = result.getString("branch");
				String gender = result.getString("gender");
				String password = result.getString("password");

				Student s = new Student(name, email1, phone, degree, branch, gender, password);
			
				 return s;
			}
           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return null;
		
		
	}
	public static  int deleteByEmail(String email) {
		String deleteQry =" Delete From Student Where email=?";
		try {
			PreparedStatement ps = connection.prepareStatement(deleteQry);
			ps.setString(1, email);
			int n=ps.executeUpdate();
			if (n>0) {
				System.out.println("  data is Deleted");
				
			} else {
				System.out.println("  data is Not Deleted");
				return 0;
			}
			return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}


//	    public boolean updateStudent(String email, String newName, String newPhone,String degree, String branch, String gender,String password) {
//	        String updateQuery = "UPDATE Student SET email=?,SET Name=?,SET phone=?,SET degree=?,SET branch=?,SET gender=?, SET password=? WHERE email=?";
//	        try {
//	            PreparedStatement ps = connection.prepareStatement(updateQuery);
//	            ps.setString(1, email);
//	            ps.setString(2, newName);
//	            ps.setString(3, newPhone);
//	            ps.setString(4, degree);
//	            ps.setString(5, branch);
//	            ps.setString(6, gender);
//	            ps.setString(7, password);
//	            ps.setString(8, email);
//	            
//	            int rowsAffected = ps.executeUpdate();
//	            if (rowsAffected > 0) {
//	                System.out.println("Student record updated successfully.");
//	                return true;
//	            } else {
//	                System.out.println(" Bekar h bhaiya mai to tut gya ");
//	                return false;
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	            return false;
//	        }
//	        
//	    }
//	    public int updateStudentByEmail(Student s) {
//	    	String updateQuery = "UPDATE Student SET Name=?,SET phone=?,SET degree=?,SET branch=?,SET gender=?, SET password=? WHERE email=?";
//			try {
//				PreparedStatement ps=connection.prepareStatement(updateQuery);
//				ps.setString(1, s.getName());
//				ps.setString(2, s.getPhone());
//				ps.setString(3, s.getDegree());
//				ps.setString(4, s.getBranch());
//				ps.setString(5, s.getGender());
//				ps.setString(6, s.getPassword());
//				ps.setString(7, s.getEmail());
//				
//				return ps.executeUpdate();
//				
//				
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return 0;
//			}
//			
//		}
	
	public void updateStudentByEmail(Student student) {
        try {
            String query = "UPDATE student SET name=?, phone=?, degree=?, branch=?, gender=?, password=? WHERE email=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getPhone());
            preparedStatement.setString(3, student.getDegree());
            preparedStatement.setString(4, student.getBranch());
            preparedStatement.setString(5, student.getGender());
            preparedStatement.setString(6, student.getPassword());
            preparedStatement.setString(7, student.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	

}
