package com.student.service;

import java.util.Scanner;

public class AdminService {
	public void adminService() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------");
		System.out.println("1. Add / Update / Delete Course");
		System.out.println("2. View All Students ");
		System.out.println("3. View All Courses ");
		System.out.println("4. View All Enrollments");
		System.out.println("5. Assign Grades(Using Functions)");
		System.out.println("6. Add Course, Student, Enrollments (Using Stored Procedure)");
		System.out.println("7. RETURN");
		System.out.println();
		System.out.print("Enter your choice:- ");
		int choice = sc.nextInt();
		switch(choice) {
			case 1:
				break;
				
			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				break;
				
			case 5:
				break;
				
			case 6:
				break;
				
			case 7:
				break;
				
			default:
		}
	}
}
