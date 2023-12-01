package db;

import java.sql.*;

public class database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Problem loeading driver");
			ex.printStackTrace();
		}
		try {
			String dbName = "javaDb.accdb";
			String dbURL = "jdbc:ucanaccess://"+dbName;
			conn = DriverManager.getConnection(dbURL);
			stat= conn.createStatement();
			rs= stat.executeQuery("SELECT * FROM employees");
			String newEmpName="Ayda";
			double newSalary=95000.00;
					
			String query = "INSERT INTO employees (name,salary) values("+newEmpName+", "+newSalary+")";
			stat.executeUpdate(query);
			
			query="DELETE employee where Id=1";
			
			
			int id;
			String name;
			double sal;
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println("Name : "+name+ " Id: " + id+ " Salary :" + sal);
			}
			}
			catch(SQLException ex) {
				System.err.println("Something has gone wrong");
				ex.printStackTrace();
			}
			finally{
				try {
					if(conn!=null) {
						rs.close();
						stat.close();
						conn.close();
					}
				
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			
		}
	}


