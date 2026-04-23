package com.student.service;

import java.util.Scanner;
import com.student.dao.StudentDao;

public class StudentService {
	
	
	public void studentService(){
		Scanner sc = new Scanner(System.in);
		StudentDao studentDao = new StudentDao();
		System.out.println("--------------------------------------");
		
		System.out.println("1. Register Student");
		System.out.println("2. Update Student Profile");
		System.out.println("3. Enroll into a Course");
		System.out.println("4. View all Courses");
		System.out.println("5. View Grade");
		System.out.println("6. Exit");
		
		
		System.out.println();
		System.out.print("Enter Your Choice : ");
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				studentDao.registerStudent();
				break;
				
			case 2:
				studentDao.updateStudent();
				break;
				
			case 3:
				System.out.print("Enter course id to enroll:-");
				int course_id = sc.nextInt();
				studentDao.enrollCourse(course_id);
				break;
				
			case 4:
				studentDao.viewCourses();
				break;
		
			case 5:
				studentDao.viewGrade();
				break;
				
			case 6:
				System.out.println("Exiting");
				return;
		}
		
		sc.close();
	}
}
