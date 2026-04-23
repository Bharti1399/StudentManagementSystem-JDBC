package com.student.service;

import java.util.Scanner;

import com.student.dao.AdminDao;

public class AdminService {
	public void adminService() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------------------------");
		System.out.println("1. Add / Update / Delete Course");
		System.out.println("2. View All Students ");
		System.out.println("3. View All Courses ");
		System.out.println("4. View All Enrollments");
		System.out.println("5. Assign Grades(Using Functions)");
		System.out.println("6. Add Courde, Student, Enrollments (Using Stored Procedure)");
		System.out.println("7. RETURN");
		System.out.println();
		System.out.print("Enter your choice:- ");
		int choice = sc.nextInt();
		AdminDao adminDao = new AdminDao();
		switch(choice) {
			case 1:
				adminDao.operationsOnCourses();
				break;
				
			case 2:
				adminDao.viewAllStudents();
				break;
				
			case 3:
				adminDao.viewAllCourses();
				break;
				
			case 4:
				adminDao.viewAllEnrollments();
				break;
				
			case 5:
//				adminDao.assignGrades();
				break;
				
			case 6:
				adminDao.addStudentCourseEnrollUsingProcedure();
				break;
				
			case 7:
				System.out.println("Exiting");
				System.exit(1);
				break;
				
			default:
		}
		sc.close();
	}
}
