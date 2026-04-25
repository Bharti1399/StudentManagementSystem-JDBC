package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminDao {

	Connection con;
	
	Scanner sc = new Scanner(System.in);
	public void operationsOnCourses() {
		System.out.println();
		System.out.println("1. Add Course \n2. Update Course \n3. Delete Course");
		System.out.print("Enter Your Choice :- ");
		int choice = sc.nextInt();
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			switch(choice) {
			case 1:{
				PreparedStatement ps = con.prepareStatement("insert into course values(?,?,?)");
				System.out.print("Enter Course ID:- ");
				ps.setInt(1, sc.nextInt());
				System.out.print("Enter Course name:- ");
				ps.setString(2, sc.next());
				System.out.print("Enter Credit Points:- ");
				ps.setInt(3, sc.nextInt());
				
				ps.execute();
				System.out.println("Data Inserted Successfully...");
				con.close();
			}
				break;
				
			case 2:{
				System.out.println();
				System.out.println("1. Update Course Name \n2. Update Course Credits");
				System.out.print("Enter your choice:- ");
				int choice1 = sc.nextInt();
				if(choice1==1) {
					PreparedStatement ps1 = con.prepareStatement("select course_id from course where course_id=?");
					System.out.print("Enter Course id:-");
					int id =sc.nextInt();
					ps1.setInt(1, id);
					ResultSet result = ps1.executeQuery();
					if(result.next()) {
						PreparedStatement ps = con.prepareStatement("update course set course_name=? where course_id=?");
						System.out.print("Enter Updated Name:- ");
						ps.setString(1, sc.next());
						ps.setInt(2,id);
						ps.execute();
						System.out.println("Course Updated Successfully...");
					}else {
						System.out.println("Course does not match...");
					}
					con.close();
				}
				else if(choice1==2) {
					PreparedStatement ps1 = con.prepareStatement("select course_id from course where course_id=?");
					System.out.print("Enter Course id:-");
					int id = sc.nextInt();
					ps1.setInt(1, id);
					ResultSet result = ps1.executeQuery();
					if(result.next()) {
						PreparedStatement ps = con.prepareStatement("update course set credits=? where course_id=?");
						ps.setInt(2,id);
						System.out.print("Enter Updated credits:- ");
						ps.setInt(1, sc.nextInt());
						ps.execute();
						System.out.println("Course Updated Successfully...");
					}else{
						System.out.println("Course id Does not match...");
					}
					con.close();
				}
				else
					System.out.println("Invalid choice...");
			}
				break;
			case 3:{
				System.out.print("Enter Course id:-");
				int id = sc.nextInt();
				PreparedStatement ps1 = con.prepareStatement("select course_id from course where course_id=?");
				ps1.setInt(1, id);
				ResultSet result = ps1.executeQuery();
				if(result.next()) {
					PreparedStatement ps = con.prepareStatement("delete from course where course_id=?");
					ps.setInt(1, id);
					ps.execute();
					System.out.println("Course Droped Successfully...");
				}else {
						System.out.println("Course does not match...");
				}
			}
				break;
			default: {
					System.out.println("Invalid choice...please enter correct option");
				    operationsOnCourses();	
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewAllStudents() {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				System.out.printf("%5d%15s%20s%15s\n",result.getInt(1),result.getString(2),result.getString(3),result.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewAllCourses() {
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			PreparedStatement ps = con.prepareStatement("select * from course");
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				System.out.printf("%5d%15s%5d\n",result.getInt(1),result.getString(2),result.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewAllEnrollments() {
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			PreparedStatement ps = con.prepareStatement("select * from enrollment");
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				System.out.printf("%5d%5d%5d%4s\n",result.getInt(1),result.getInt(2),result.getInt(3),result.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void assignGrades(int enroll_id) {
		try {
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system", "postgres", "root");
			PreparedStatement ps1 = con.prepareStatement("select * from enrollment where enroll_id=?");
			ps1.setInt(1, enroll_id);
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				PreparedStatement ps = con.prepareStatement("select update_grade(?,?)");
				System.out.print("Enter the grades:-");
				ps.setString(1, sc.next());
				ps.setInt(2, enroll_id);
				ps.execute();
				System.out.println("Grade Updated Successfully....");
				con.close();
			}else {
				System.out.print("Enrollment Id is not present...");
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addStudentCourseEnrollUsingProcedure() {
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			PreparedStatement ps = con.prepareStatement("call insert_data(?,?,?,?,?,?,?,?,?)");
			System.out.print("Enter Course Id:-");
			ps.setInt(1, sc.nextInt());
			System.out.print("Enter Course Name:-");
			ps.setString(2, sc.next());
			System.out.print("Enter Course Credit:- ");
			ps.setInt(3, sc.nextInt());
			System.out.print("Enter Enrollment Id:-");
			ps.setInt(4, sc.nextInt());
			System.out.print("Enter grades:-");
			ps.setString(5, sc.next());
			System.out.print("Enter Student Id:-");
			ps.setInt(6, sc.nextInt());
			System.out.print("Enter Student Name:-");
			ps.setString(7, sc.next());
			System.out.print("Enter Student Email:-");
			ps.setString(8, sc.next());
			System.out.print("Enter Student DOB:-");
			ps.setString(9, sc.next());

			ps.execute();
			System.out.println("Data Inserted Successfully....");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
