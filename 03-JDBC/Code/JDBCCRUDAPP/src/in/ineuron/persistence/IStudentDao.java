package in.ineuron.persistence;

import in.ineuron.dto.Student;

public interface IStudentDao {
	
	//operations to be implementd 
	public String addStudent(String sname,Integer sage,String saddress);
	
	public Student searchStudent(Integer id);
	
	public String updateStudent(Integer sid,String sname,Integer sage,String saddress);
	
	public String deleteStudent(Integer sid);
	
	
}
