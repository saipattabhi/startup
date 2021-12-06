package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysql {
	
	public static void main(String[] args) throws SQLException
	{
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saidatabase", "root", "Sai@2255");
		
		
		if(connection.isClosed())
		{
			
			System.out.println("We are not connected to database");
			
		}
		else {
			System.out.println("I connected to data base");
		}
		
		
		         Statement statement = connection.createStatement();
		         
		   ResultSet resultset = statement.executeQuery("Select * from employee where EmpId=4");
		   
		   while(resultset.next())
		   {
			   
			 System.out.println(  resultset.getInt("EmpId"));
			  System.out.println(resultset.getString("EmpName")) ;
			  System.out.println(resultset.getInt("EmpAge"));
			  System.out.println(resultset.getString("EmpDept"));
			  
			   
		   }
		
		
		
		
	}
	
	
	
	

}
