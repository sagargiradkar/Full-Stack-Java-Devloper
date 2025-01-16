package in.ineuron.dao;

import java.util.List;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dto.EmployeeDTO;

public interface IEmployeeDao {
	public List<EmployeeBO> fetchEmployeesByDesg(String desg1,String desg2,String desg3);
	public String registeredEmployee(EmployeeBO bo);
	public String getEmployeeByName(int no);
	
}
