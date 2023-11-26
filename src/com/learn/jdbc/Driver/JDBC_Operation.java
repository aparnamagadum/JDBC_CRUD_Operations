package com.learn.jdbc.Driver;
import java.sql.*;
import java.util.*;;
public class JDBC_Operation {
	//Perform Insertion
	public static void insert(Connection con) throws Exception {
		String query="insert into emp values(?,?,?)";
		PreparedStatement pmt=con.prepareStatement(query);
		Scanner scr=new Scanner(System.in);
		System.out.println("Enter number of rows to be inserted");
		int n=scr.nextInt();
		int i=1;
		while(i<=n) {
		System.out.println("Enter Id");
		int id=scr.nextInt();
		System.out.println("Enter Name");
		String name=scr.next();
		System.out.println("Enter Salary");
		int sal=scr.nextInt();
		pmt.setInt(1, id);
		pmt.setString(2, name);
		pmt.setInt(3, sal);
		pmt.addBatch();
		i++;
		}
		pmt.executeBatch();
		System.out.println("rows inserted");
	}
	//Perform Update Operation
	public static void update(Connection con) throws Exception {
		String query="update emp set name=? where id=?";
		PreparedStatement pmt=con.prepareStatement(query);
		Scanner scr=new Scanner(System.in);
		System.out.println("Enter number of rows to be update");
		int n=scr.nextInt();
		int i=1;
		while(i<=n) {
		System.out.println("Enter the Id of record to be Update");
		int id=scr.nextInt();
		System.out.println("Enter Name To be set");
		String name=scr.next();
		pmt.setInt(1, id);
		pmt.setString(2, name);
		pmt.addBatch();
		i++;
		}
		pmt.executeBatch();
		System.out.println("rows updated");
	}
	//Perform Delete Operation
	public static void delete(Connection con) throws Exception {
		String query="delete from emp where id=?";
		PreparedStatement pmt=con.prepareStatement(query);
		Scanner scr=new Scanner(System.in);
		System.out.println("Enter number of rows to be delete");
		int n=scr.nextInt();
		int i=1;
		while(i<=n) {
		System.out.println("Enter the Id of record to be delete");
		int id=scr.nextInt();
		pmt.setInt(1, id);
		pmt.addBatch();
		i++;
		}
		pmt.executeBatch();
		System.out.println("rows Deleted");
	}
	//Retriving the Data From Table
	public static void retrive(Connection con) throws SQLException {
		String query="select * from emp";
		PreparedStatement pmt=con.prepareStatement(query);
		ResultSet rs=pmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		System.out.println("rows are retrived");
	}
     public static void main(String[] args) throws Exception {
	//Loading Driver is Optional in MySQL
	Scanner scr=new Scanner(System.in);
	//employee is an Database name
	String url="jdbc:mysql://localhost:3306/employee";
	System.out.println("enter username of mysql");
	String user=scr.next();
	System.out.println("enter a password of mysql");
	String pass=scr.next();
	Connection con=DriverManager.getConnection(url,user,pass);
	System.out.println("Connection established");
	System.out.println("enter 1 for insert , enter 2 for update , enter 3 for delete , enter 4 for select");
	while(true) {
	System.out.println("enter the choice");
	int ch=scr.nextInt();
	if(ch==1) {
		System.out.println("Perform Insertion");
	insert(con);
		}
	else if(ch==2) {
		System.out.println("Perform Update Operation");
	update(con);
	}
	else if(ch==3) {
		System.out.println("Perform Deletion");
	delete(con);
		}
	else if(ch==4) {
		System.out.println("Retrive the Data");
	retrive(con);
		}
	else {
		System.out.println("Please enter the Correct Choice");
		}
	}
}
}

