package jdbc.noida.prepraredstatement.project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jdbc.noida.prepraredstatement.project.connection.StudentConnection;
import jdbc.noida.prepraredstatement.project.dto.Student;

public class StudentDao {
	
	Connection con=null;
	PreparedStatement ps;	
	public void insertStudent(List <Student> s) {
		con=StudentConnection.getConnection();
		
		try {
			String insert="insert into student values(?,?,?)";
			ps = con.prepareStatement(insert);
			for (Student student : s) {
				ps.setInt(1, student.getId());
				ps.setString(2, student.getName());
				ps.setString(3, student.getEmail());
//				System.out.println(student.getId());
				ps.addBatch();
			}
			ps.executeBatch();
			System.out.println("Data inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// getById
	
	public int getById(int id) {
		con= StudentConnection.getConnection();
		
		String select="select * from student where id=?";
		
		try {
			PreparedStatement 	ps = con.prepareStatement(select);
			ps.setInt(1, id);
			ResultSet resultset=ps.executeQuery();
			resultset.next();
			int id1=resultset.getInt("id");
			return id1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public void updateStudentByName(int id,String name) {
		con=StudentConnection.getConnection();
		String update="Update student set name=? where id=?";
		try {
			ps=con.prepareStatement(update);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("Name updated...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateStudentByEmail(int id,String email) {
		con=StudentConnection.getConnection();
		String update="Update student set email=? where id=?";
		try {
			ps=con.prepareStatement(update);
			ps.setInt(2, id);
			ps.setString(1, email);
			ps.executeUpdate();
			System.out.println("Email updated...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteStudent(int id) {
		con=StudentConnection.getConnection();
		try {
			String delete ="delete from student where id=?";
			ps=con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("data deleted !!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Student> displayStudent() {
		
		con=StudentConnection.getConnection();
		
		String display ="Select * from student";
		
		try {
			PreparedStatement ps =con.prepareStatement(display);
			ResultSet rs =	ps.executeQuery();
			List <Student> list =new ArrayList<Student>();
			while(rs.next()) {
				Student student =new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				
				list.add(student);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
