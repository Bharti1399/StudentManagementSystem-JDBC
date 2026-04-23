package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDao {
	
	Scanner sc = new Scanner(System.in);
	
	public void registerStudent(){
		try {
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
			System.out.println("Enter how many records want to insert :-");
			int count = sc.nextInt();
			for(int i=0;i<count;i++) {
				System.out.print("Enter Student id:- ");
				ps.setInt(1, sc.nextInt());
				
				System.out.print("Enter Student name:- ");
				ps.setString(2,sc.next());
				
				System.out.print("Enter Student email id:- ");
				ps.setString(3, sc.next());
				
				System.out.print("Enter Student DOB:- ");
				ps.setString(4, sc.next());
				
				ps.addBatch();
				System.out.println("----------------------");
			}
			ps.executeBatch();
			System.out.println("Data Inserted Successfully....");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent() {
		Connection con = null;
		try {
			con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			System.out.println("1. Update Student Name \n2. Update Student Email Id \n3. Update Date of Birth");
			System.out.print("Enter your choice:-");
			int choice = sc.nextInt();
			if(choice==1) {
				System.out.print("Enter Student Id :- ");
				int student_id=sc.nextInt();
				
				PreparedStatement ps1 = con.prepareStatement("select student_name from student where student_id=?");
				ps1.setInt(1, student_id);	
				
				ResultSet result = ps1.executeQuery();
				if(result.next()) {
					PreparedStatement ps = con.prepareStatement("update student set student_name=? where student_id=?");
					ps.setInt(2, student_id);
					System.out.print("Enter your name to Updated :- ");
					ps.setString(1, sc.next());
					ps.executeUpdate();
					System.out.println("Name Updated Successfully...");
				}else {
					System.out.println("Student Not Found....");
				}
			}
			else if(choice==2) {
				System.out.print("Enter Student Id :- ");
				int student_id=sc.nextInt();
				
				PreparedStatement ps1 = con.prepareStatement("select student_name from student where student_id=?");
				ps1.setInt(1, student_id);	
				
				ResultSet result = ps1.executeQuery();
				if(result.next()) {
					PreparedStatement ps = con.prepareStatement("update student set student_email=? where student_id=?");
					ps.setInt(2, student_id);
					System.out.print("Enter your email to Updated :- ");
					ps.setString(1, sc.next());
					ps.executeUpdate();
					System.out.println("Email Updated Successfully...");
				}else {
					System.out.println("Student Not Found....");
				}	
			}
			else if(choice==3) {
				System.out.print("Enter Student Id :- ");
				int student_id=sc.nextInt();
				
				PreparedStatement ps1 = con.prepareStatement("select student_name from student where student_id=?");
				ps1.setInt(1, student_id);	
				
				ResultSet result = ps1.executeQuery();
				if(result.next()) {
					PreparedStatement ps = con.prepareStatement("update student set date_of_birth=? where student_id=?");
					ps.setInt(2, student_id);
					System.out.print("Enter your DOB to Updated :- ");
					ps.setString(1, sc.next());
					ps.executeUpdate();
					System.out.println("DOB Updated Successfully...");
				}else {
					System.out.println("Student Not Found....");
				}	
			}
			else {
				System.out.println("invalid choice....");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void enrollCourse(int course_id) {
		try {
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			PreparedStatement ps1 = con.prepareStatement("select * from course where course_id=?");
			ps1.setInt(1, course_id);
			ResultSet result = ps1.executeQuery();
			if(result.next()) {
					PreparedStatement ps = con.prepareStatement("insert into enrollment values(?,?,?,?)");
						System.out.print("Enter Enrollment id:- ");
						ps.setInt(1, sc.nextInt());
						
						System.out.print("Enter Student id:- ");
						ps.setInt(2,sc.nextInt());
					
						ps.setInt(3, course_id);
						
						System.out.print("Enter grades of course:- ");
						ps.setString(4, sc.next());
						
					ps.execute();
					System.out.println("Course Enrollment Successfully....");
			}else {
				System.out.println("Course id does not match...");
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void viewCourses() {
		try {
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			PreparedStatement ps = con.prepareStatement("select * from course");
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				System.out.printf("%5d    |%10s    | %10d",result.getInt(1),result.getString(2),result.getInt(3));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void viewGrade() {
		try {
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			PreparedStatement ps = con.prepareStatement("select c.course_name, e.grade from enrollment e, course c where e.student_id=?");
			System.out.print("Enter student id:-");
			ps.setInt(1, sc.nextInt());
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				System.out.printf("%10s%7s",result.getString(1),result.getString(2));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
