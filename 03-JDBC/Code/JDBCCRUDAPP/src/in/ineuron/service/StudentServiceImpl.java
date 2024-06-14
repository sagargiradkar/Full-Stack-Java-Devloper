package in.ineuron.service;

import in.ineuron.daoFactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDao;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(sname, sage, saddress);
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
