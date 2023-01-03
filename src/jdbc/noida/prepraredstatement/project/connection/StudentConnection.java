package jdbc.noida.prepraredstatement.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {
	static Connection con;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc.noida.prepraredstatement.project","root", "Ytrewq@24680");
			
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
