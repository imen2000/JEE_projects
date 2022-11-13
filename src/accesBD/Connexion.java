package accesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	private static String url="jdbc:mysql://localhost:3306/bdpizza";
	private static String user="root";
	private static String pw="";
	
	private static Connection connect;
	
	private Connexion(){}
	
	public static Connection getInstance() throws SQLException {
		if (connect==null ||connect.isClosed())
			connect= DriverManager.getConnection(url,user,pw);
		return connect;
	}
	
	public void close() throws SQLException {
		if (connect!=null && !connect.isClosed())
			connect.close();
	}
	
	public static void main(String[] args) throws SQLException {
		Connection connect= Connexion.getInstance();
		System.out.println(connect);
	}

}
