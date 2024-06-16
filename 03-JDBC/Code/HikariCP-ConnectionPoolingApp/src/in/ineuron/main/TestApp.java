package in.ineuron.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String configFile="src\\in\\ineuron\\main\\db.properties";
		HikariConfig config= new HikariConfig(configFile);
		
		
		tyr(HikariDataSourse dataSource = new HikariDataSource(config)){
			Connection connection = dataSource.getConnection();
			Statement statment = connection.createStatement();
			
			ResultSet resultSet = statment.executeQuery("select id,name,age,address from employee");
			System.out.println("ID\tNAME\tAGE\tADDRESS");
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+resultSet.getString(4));
			}
		}
		
	}

}
