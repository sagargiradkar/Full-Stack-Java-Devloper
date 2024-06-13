package in.ineuron.service;

import in.ineuron.dto.Student;
import in.ineuron.servicefactory.StudentServiceFactory;

public class StudentServiceImpl implements IStudentService {

	IStudentService stdService;
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdService = StudentServiceFactory.getStudentService();
		return null;
	}

	@Override
	public Student searchStudent(Integer id) {
		return null;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		return null;
	}

}
