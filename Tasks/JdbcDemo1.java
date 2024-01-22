package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JdbcDemo1 {
	
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement ps;
	private static String dname;
	private static String tname;
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {	//main method
		final String link = "jdbc:mysql://localhost:3306/";
		final String uname = "root";
		final String pass = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");	// Registering the driver
		con = DriverManager.getConnection(link,uname,pass);	// Establishing the connection
		System.out.println("Connection established....");
		st = con.createStatement();
		JdbcDemo1.chooseFuction();
	}
		public static void chooseFuction() throws SQLException {
			try{
		int choice;
		do {
			
			System.out.println("1. Create database \n2. Create table \n3. Insert data \n4. View table \n5. View data by ID \n6. Update data \n7. Delete \n8. Exit");
			choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				JdbcDemo1.createDb();
				break;
			case 2:
				JdbcDemo1.createTable();
				break;
			case 3:
				JdbcDemo1.insertData();
				break;
			case 4:
				JdbcDemo1.viewTable();
				break;
			case 5:
				JdbcDemo1.viewDataId();
				break;
			case 6:
				JdbcDemo1.update();
				break;
			case 7:
				JdbcDemo1.delete();
				break;
			case 8:
				System.out.println("Thanks for using our application :)");
				break;
			default:
				System.out.println("No functions found for this number: ");
			}
			
		}while(choice !=8);}

			catch(InputMismatchException e) {
				System.out.println("Enter only numbers for selection");
			}
}

	private static void createDb() throws SQLException {
		System.out.println("Enter the database name");
		String dbname = scan.next();
		String query = "create database if not exists "+dbname;
		st.executeUpdate(query);
		System.out.println("Database created sucessfully....");
	}
	
	private static void createTable() throws SQLException {
		JdbcDemo1.selectDbandTable();
		st.executeUpdate("create table if not exists "+tname+" ("
				+"EmpID int auto_increment primary key,"
				+"Name varchar(50),"
				+"Age int,"
				+"Salary decimal(12,4),"
				+"Location varchar(40)"
				+");");
		System.out.println("Table created sucessfully");
		
	}
	
	private static void insertData() throws SQLException {
		JdbcDemo1.selectDbandTable();
		System.out.println("Enter the name: ");
		String name = scan.next();
		System.out.println("Enter the age: ");
		int age = scan.nextInt();
		System.out.println("Enter the salary: ");
		double salary = scan.nextDouble();
		System.out.println("Enter the location: ");
		String location = scan.next();
		String query = "insert into "+tname+" (Name,Age,Salary,Location) values(?,?,?,?);";
		ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setDouble(3, salary);
		ps.setString(4, location);
		int rows = ps.executeUpdate();
        System.out.println(rows + " rows inserted successfully!");
	
	}

	private static void viewTable() throws SQLException {
		JdbcDemo1.selectDbandTable();
		String query = "select *from "+tname;
		rs = st.executeQuery(query);
		 for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
             System.out.print(rs.getMetaData().getColumnName(i) + "\t");
         }
         System.out.println();
		while (rs.next()) {
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
		}
		
	}
	
	private static void viewDataId() throws SQLException {
		JdbcDemo1.selectDbandTable();
		System.out.println("Enter the employee Id for fetching data: ");
		int empid = scan.nextInt();
         String query = "SELECT * FROM " + tname + " WHERE EmpID = ?";
         ps = con.prepareStatement(query);
		ps.setInt(1, empid);
		rs = ps.executeQuery();
		 while (rs.next()) {
             for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                 String columnName = rs.getMetaData().getColumnName(i);
                 Object columnValue = rs.getObject(i);
                 System.out.println(columnName + ": " + columnValue);
             	}
             }
		 }
	
	private static void update() throws SQLException {
		JdbcDemo1.selectDbandTable();
		System.out.println("Enter the employee Id for fetching data: ");
		int empid = scan.nextInt();
		System.out.println("Enter the coloumn name exactly (Name or Age or Salary or Location)");
		String colname = scan.next(); 
		String query = "update " + tname +" set "+ colname + " = ?"+ " where EmpID= "+empid;
		ps = con.prepareStatement(query);
		
		switch(colname)
		{
		case "Name":
			System.out.println("Enter the new name for updation: ");
			String newname = scan.next();
			ps.setString(1, newname);
			break;
		case "Age":
			System.out.println("Enter the new age for updation: ");
			int newage = scan.nextInt();
			ps.setInt(1, newage);
			break;
		case "Salary":
			System.out.println("Enter the new salary for updation: ");
			double newsalary = scan.nextDouble();
			ps.setDouble(1, newsalary);
			break;
		case "Location":
			System.out.println("Enter the new location for updation: ");
			String newlocation = scan.next();
			ps.setString(1, newlocation);
			break;
		default:
			System.out.println("Enter the correct number....");
			break;
		}
		int rowsAffected = ps.executeUpdate();
	    System.out.println("Rows affected: " + rowsAffected);
	}

	private static void delete() throws SQLException {
		JdbcDemo1.selectDbandTable();
		System.out.println("Enter the employee Id for deletion: ");
		int empid = scan.nextInt();
		String query = "delete from "+tname+" where EmpID = "+empid;
		ps = con.prepareStatement(query);
		System.out.println("Employee data deleted successfully :)");
		int rows = ps.executeUpdate();
		System.out.println(rows +" affected...");
	}
	
    private static void selectDbandTable() throws SQLException {
    	System.out.println("Enter the database name: ");
		 dname = scan.next();
		System.out.println("Enter the table name: ");
		 tname = scan.next();
		 st.executeUpdate("use "+dname);
    }
}
