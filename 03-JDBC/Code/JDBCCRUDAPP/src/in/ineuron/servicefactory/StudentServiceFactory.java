package in.ineuron.servicefactory;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

//Connection connection = DriverManager.getConnection(url,username,password)
public class StudentServiceFactory {
	
	//make constructor private to avoid objevt 
	private StudentServiceFactory()
	{
		
	}
	private static IStudentService studentService = null;
	public static IStudentService getStudentService()
	{	
		if(studentService==null) {
		studentService = new StudentServiceImpl();
		
		}
		return studentService;
		
	}
}
