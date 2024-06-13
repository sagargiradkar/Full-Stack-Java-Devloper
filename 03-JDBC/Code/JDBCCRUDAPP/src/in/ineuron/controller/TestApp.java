package in.ineuron.controller;

import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) {

		//Connection connection = DriverManager.getConnection(url,username,password); 
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = studentService.addStudent("sachin", 49, "MI");
		if(msg.equalsIgnoreCase("succes")) {
			System.out.println("Record inserted succesfully .....");
		}
		else {
			System.out.println("Record insertion failed .....");
		}
	}

}
