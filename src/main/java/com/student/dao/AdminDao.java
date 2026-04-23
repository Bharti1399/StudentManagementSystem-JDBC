package com.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminDao {

	Scanner sc = new Scanner(System.in);
	public void operationsOnCourses() {
		System.out.println();
		System.out.println("1. Add Course \n2. Update Course \n3. Delete Course");
		System.out.print("Enter Your Choice :- ");
		int choice = sc.nextInt();
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
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
		Connection con;
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
		Connection con;
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
	
	public void assignGrades() {
		Connection con;
		try {
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432", "potgres", "root");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addStudentCourseEnrollUsingProcedure() {
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_management_system?user=postgres&password=root");
			PreparedStatement ps = con.prepareStatement("call insertCourseStudentEnrollment(?,?,?,?,?,?,?,?,?)");
			System.out.print("Enter Enrollment id:-");
			ps.setInt(1, sc.nextInt());
			System.out.print("Enter Grade:-");
			ps.setString(2, sc.next());
			System.out.print("Enter Student id:-");
			ps.setInt(3, sc.nextInt());
			System.out.print("Enter Student Name:-");
			ps.setString(4, sc.next());
			System.out.print("Enter Student email id:-");
			ps.setString(5, sc.next());
			System.out.print("Enter DOB:-");
			ps.setString(6, sc.next());
			System.out.print("Enter Course id:-");
			ps.setInt(7, sc.nextInt());
			System.out.print("Enter Course Name:-");
			ps.setString(8, sc.next());
			System.out.print("Enter Credits:-");
			ps.setInt(9, sc.nextInt());

			System.out.print("hi");
			
			ps.execute();
			System.out.println("Data Inserted Successfully....");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
