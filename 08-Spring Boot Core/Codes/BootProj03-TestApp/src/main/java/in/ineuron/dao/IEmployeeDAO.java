package in.ineuron.dao;

import in.ineuron.model.Employee;

import java.util.List;

public interface IEmployeeDAO {
    public List<Employee> findAllEmployees() throws Exception;

}
