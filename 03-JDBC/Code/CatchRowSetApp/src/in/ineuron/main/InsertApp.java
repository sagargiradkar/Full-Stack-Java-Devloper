package in.ineuron.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class InsertApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();
		
		//setting urls,username,password
		jrs.setUrl("jdbc:mysql:///ineuron");
		jrs.setUsername("root");
		jrs.setPassword("9402");
		
	//setting a commands for execution
		
		jrs.setCommand("select id ,name,age,address from student");
		
		jrs.execute();
		
		Scanner sc  = new Scanner(System.in);
		jrs.moveToInsertRow();
		while(true) {
			
			System.out.println("Enter the id :: ");
			Integer id = sc.nextInt();
			System.out.println("Enter the name :: ");
			String name = sc.next();
			
			System.out.println("Enter the age :: ");
			Integer age = sc.nextInt();
			
			System.out.println("Enter the address :: ");
			String address = sc.next();
			
			jrs.updateInt(1, id);
			jrs.updateString(2, name);
			jrs.updateInt(3, age);
			jrs.updateString(4, address);
			
			jrs.insertRow();
			
			System.out.println("Record inserted successfully .....");
			System.out.println("Do you want to insert more record[yes/no]");
			String option = sc.next();
			
			if(option.equalsIgnoreCase("No")) {
				break;
			}
			
		}
		sc.close();
		jrs.close();
	}

}
