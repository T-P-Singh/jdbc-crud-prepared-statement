package jdbc.noida.prepraredstatement.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import jdbc.noida.prepraredstatement.project.dto.Student;
import jdbc.noida.prepraredstatement.project.service.StudentService;

public class StudentController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		
		StudentService ss=new StudentService();
		while(true) {
			
			System.out.println("======================================================\n");
			System.out.println("Choose your option");
			System.out.println("1. Insert\n2. getById \n3. Update\n4. Delete\n5. Display all");
			
			
			int choice=sc.nextInt();
			switch (choice) {
			case 1:{
				
				System.out.println("Enter how many student data you want to add");
				
				int size= sc.nextInt();
				
				List<Student> list=new ArrayList<Student>();
				
				
				for(int i=0;i<size;i++) {
					Student student =new Student();
					
					System.out.print("Enter the student id: ");
					student.setId(sc.nextInt());
					System.out.print("Enter the student name: ");
					student.setName(sc.next());
					System.out.print("Enter the student email: ");
					student.setEmail(sc.next());
					
					list.add(student);
				}
				 ss.insertStudent(list);
				
			}break;
			case 2:{
				System.out.println("Enter the id to fetch student data");
				
				int id =ss.getById(sc.nextInt());
				System.out.println(id);
			}break;
			case 3:{
				System.out.println("1. Update name\n2. Update email\n3. Go back.");
				System.out.println("Enter the  column number you want to update: ");
				int ch =sc.nextInt();
				switch(ch) {
				case 1:{
					System.out.print("Enter the student id you want to update");
					int id=sc.nextInt();
					System.out.print("Enter the updated name:");
					String name=sc.next();
					ss.updateStudentByName(id, name);
				}break;
				case 2:{
					System.out.print("Enter the student id you want to update");
					int id=sc.nextInt();
					System.out.print("Enter the updated email:");
					String email=sc.next();
					ss.updateStudentByEmail(id, email);
				}break;
				case 3:{
					return ;
				}	
				}
				
			}break;
			case 4:{
				System.out.println("Enter the id you want to delete");
				int id=sc.nextInt();
				ss.deleteStudent(id);
			}break;
			case 5:{
				List <Student>students =ss.displayStudent();
				
				System.out.println("Id\t\tName\t\tEmail");
				for (Student student2 : students) {
					
					System.out.print( student2.getId()+"\t\t");
					System.out.print( student2.getName()+"\t\t");
					System.out.print( student2.getEmail()+"\t\t");
					System.out.println();
				}	
			}break;
				
			default:
				break;		
			}
			
		}
		
	}

}
