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

public class TestApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();
		CachedRowSet crs = rsf.createCachedRowSet();
		WebRowSet wrs = rsf.createWebRowSet();
		JoinRowSet jnrs = rsf.createJoinRowSet();
		FilteredRowSet frs = rsf.createFilteredRowSet();
		
		System.out.println(jrs.getClass().getName());
		System.out.println(crs.getClass().getName());
		System.out.println(wrs.getClass().getName());
		System.out.println(jnrs.getClass().getName());
		System.out.println(frs.getClass().getName());
	}

}
