package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	
	//operation to be implememted 
	public String addStudent(String sname,Integer sage,String saddress);
	
	public Student searchStudent(Integer id);
	
	public String updateStudent(Integer sid,String sname,Integer sage,String saddress);
	
	public String deleteStudent(Integer sid);
	
	
}
