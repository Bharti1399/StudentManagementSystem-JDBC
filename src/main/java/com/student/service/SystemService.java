package com.student.service;

import java.util.Scanner;
import com.student.dao.SystemDao;

public class SystemService {
	
	public void systemService() {
		Scanner sc = new Scanner(System.in);
		SystemDao systemDao = new SystemDao();
		System.out.println("-----------------------------");
        System.out.println("Student Registration");
        System.out.println("Update Student Details");
        System.out.println("Course Enrollment");
        System.out.println("View Courses");
        System.out.println("Grade Tracking");
        System.out.println("Admin Controls");
        System.out.println("Exit");
        System.out.println();
        System.out.print("Enter your choice :-");
        switch(sc.nextInt()) {
	        case 1:
	        	systemDao.registerStudent();
	        	break;
	        	
	        case 2:
	        	systemDao.updateStudent();;
	        	break;
	        	
	        case 3:
	        	System.out.print("Enter Course Id :-");
	        	systemDao.enrollCourse(sc.nextInt());
	        	break;
	        	
	        case 4:
	        	systemDao.viewCourses();
	        	break;
	        	
	        case 5:
	        	break;
	        	
	        case 6:
	        	break;
	        
	        case 7:
	        	System.out.println("Exiting...");
	        	System.exit(0);
	        	break;
	        	
	        default :System.out.print("invalid choice...");
        }
    }
}
