package in.ineuron.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class JDBCRowSet {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();
		
		//setting urls,username,pass
		jrs.setUrl("jdbc:mysql:///ineuron");
		jrs.setUsername("root");
		jrs.setPassword("9402");
		
	//setting a commands for execution
		
		jrs.setCommand("select id ,name,age,address from student");
		
		jrs.execute();
		
		System.out.println("Retrieving the record in forword direcvtion...");
		System.out.println("ID\tNAME\tAGE\tAddress");
		while(jrs.next()) {
			System.out.
			println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getInt(3)+"\t"+jrs.getString(4));
		}
		
		System.out.println();
	
		System.out.println("Retrieving the record in backword direcvtion...");
		System.out.println("ID\tNAME\tAGE\tAddress");
		while(jrs.previous()) {
			System.out.
			println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getInt(3)+"\t"+jrs.getString(4));
		}
		System.out.println();
		jrs.relative(-5);
		jrs.absolute(3);
		System.out.
		println(jrs.getInt(1)+"\t"+jrs.getString(2)+"\t"+jrs.getInt(3)+"\t"+jrs.getString(4));
	
	}

}
