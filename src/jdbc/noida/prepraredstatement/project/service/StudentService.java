package jdbc.noida.prepraredstatement.project.service;

import java.util.List;

import jdbc.noida.prepraredstatement.project.dao.StudentDao;
import jdbc.noida.prepraredstatement.project.dto.Student;

public class StudentService {

	StudentDao dao=new StudentDao();
	
	public void insertStudent(List <Student> s) {
		
		dao.insertStudent(s);
	}
	public int getById(int id) {
		return dao.getById(id);
	}
	public void updateStudentByName(int id, String name) {
		if(id==dao.getById(id)) {
			dao.updateStudentByName(id, name);
		}else {
			System.out.println("Id not present in the database.");
		}
	}
	public void updateStudentByEmail(int id,String email) {
		if(id==dao.getById(id)) {
			dao.updateStudentByEmail(id, email);
		}else {
			System.out.println("Id not present in the database.");
		}
	}
	public void deleteStudent(int id) {
		if(id==getById(id)) {
			dao.deleteStudent(id);
		}else {
			System.out.println("No such id present in database where id = "+id);
		}
	}
	public List<Student> displayStudent() {
		return dao.displayStudent();
	}
	
}
