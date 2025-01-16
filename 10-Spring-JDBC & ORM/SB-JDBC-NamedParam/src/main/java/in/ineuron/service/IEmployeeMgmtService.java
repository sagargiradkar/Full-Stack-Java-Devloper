package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	public List<EmployeeDTO> fetchEmployeesByDesg(String desg1,String desg2,String desg3);
	public String registeredEmployee(EmployeeDTO dto);
	public String fetchEmployeeByNo(int no);
	

}
