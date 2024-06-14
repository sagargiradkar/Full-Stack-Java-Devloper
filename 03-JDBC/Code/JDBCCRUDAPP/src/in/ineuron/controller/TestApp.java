package in.ineuron.controller;

import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) {
 
		//Connection connection = DriverManager.getConnection(url,username,password); 
		insertOperation();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id :: ");
		int sid = scanner.nextInt();
		
		IStudentService studentService = StudentServiceFactory.getStudentService();

		Student std = studentService.searchStudent(sid);
		if(std != null)
		{
			System.out.println(std);
			System.out.println("SID\tSNAME\tSAGE\tSADDR");
			System.out.println(std.getSid()+"\t"+std.getSname()+"\t"
					+std.getSage() +"\t"+std.getSaddress());
		}else {
			System.out.println("Rescord not found the given id :: "+sid);
		}
		
		scanner.close();
		
		
	}
	private static void insertOperation()
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student name :: ");
		String sname = scanner.next();
		
		
		System.out.print("Enter the student age :: ");
		int sage = scanner.nextInt();
		
		System.out.print("Enter the student address :: ");
		String saddress = scanner.next();
		
		String msg = studentService.addStudent(sname, sage, saddress);
		if(msg.equalsIgnoreCase("succes")) {
			System.out.println("Record inserted succesfully .....");
		}
		else {
			System.out.println("Record insertion failed .....");
		}
		
		scanner.close(); 
	}

}
