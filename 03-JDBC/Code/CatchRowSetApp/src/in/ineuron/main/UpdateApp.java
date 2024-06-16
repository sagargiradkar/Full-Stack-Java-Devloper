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

public class UpdateApp {

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
		
		while(jrs.next()) {
			int actualSalary = jrs.getInt(5);
			if(actualSalary < 5000) {
				int updatedSalary = actualSalary+1000;
				jrs.updateInt(5, updatedSalary);
				jrs.updateRow();
			}
		}
		System.out.println("Record updated successfully ....");
		jrs.close();
	}

}
