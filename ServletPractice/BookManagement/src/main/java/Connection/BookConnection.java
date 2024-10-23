package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class BookConnection {
public static Connection getCooncetion() {
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	
	
		 String url = "jdbc:mysql://localhost:3306/servlet";
         String user = "root";
         String pass = "9999";
         return DriverManager.getConnection(url, user, pass);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}
}
