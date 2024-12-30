package in.ineuron.dao;

import in.ineuron.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("empDao")
public class EmployeeDaoImpl implements IEmployeeDAO{

    private static final String SQL_SELECT_QUERY = "select eid,ename,eage,eaddress from employee";
	@Autowired
    private DataSource dataSource;

    @Override
    public List<Employee> findAllEmployees() throws Exception {
        System.out.println("Datasource Name :: "+dataSource.getClass().getName());
        ArrayList<Employee> empList = null;
        try(Connection connection = dataSource.getConnection();
        		PreparedStatement pstm = connection.prepareStatement(SQL_SELECT_QUERY);
        		ResultSet resultSet = pstm.executeQuery()){
        	
        	empList = new ArrayList<Employee>();
        	while(resultSet.next()) {
        		Employee employee = new Employee();
        		employee.setEid(resultSet.getInt(1));
        		employee.setEname(resultSet.getString(2));
        		employee.setEage(resultSet.getInt(3));
        		employee.setEaddress(resultSet.getString(4));
        		empList.add(employee);
        		
        	}
        	
        }
        return empList;
    }
}
