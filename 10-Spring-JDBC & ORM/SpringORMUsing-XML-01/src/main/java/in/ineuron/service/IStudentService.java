package in.ineuron.service;


import java.util.List;

import in.ineuron.bo.StudentBO;
import in.ineuron.dto.StudentDTO;

public interface IStudentService {
	 public int insert(StudentBO s); 
	    public void delete(int id); 
	    public void delete(StudentBO s); 
	    public void update(StudentBO s); 
	    public StudentBO getStudent(int id); 
	    public List<StudentBO> getAllStudents(); 
}
