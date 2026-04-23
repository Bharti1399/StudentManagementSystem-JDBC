package com.student.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.student.service.AdminService;
import com.student.service.StudentService;

public class StudentDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Student Management System....");
		System.out.println();
		
		StudentService studentService = new StudentService();
		AdminService adminService = new AdminService();
		
		System.out.println("1. Student Menu");
		System.out.println("2. Admin Menu");
		System.out.println("3. System Features");
		System.out.println("4. EXIT");
		System.out.println();
		
		System.out.print("Enter your choice :- ");
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:{
				System.out.println();
				System.out.println("Student Menu...");
				studentService.studentService();
			}
			break;
			
			case 2:{
				System.out.println();
				System.out.println("Admin Menu...");
				adminService.adminService();
			}
			break;
				
			case 3:{
				System.out.println();
				System.out.println("System Features");
			}
			break;
				
			case 4:{
				System.out.println();
				System.out.println("Exited");
//				return;
				System.exit(1);
			}
			break;
				
			default:{
				System.out.println();
				System.out.println("Invalid Choice...");
			}
		}
		
	}
}
