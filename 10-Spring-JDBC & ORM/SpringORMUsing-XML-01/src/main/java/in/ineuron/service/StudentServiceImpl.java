package in.ineuron.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDao;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao dao;

    @Override
    public int insert(StudentBO s) {
        return dao.insert(s);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void delete(StudentBO s) {
        dao.delete(s);
    }

    @Override
    public void update(StudentBO s) {
        dao.update(s);
    }

    @Override
    public StudentBO getStudent(int id) {
        return dao.getStudent(id);
    }

    @Override
    public List<StudentBO> getAllStudents() {
        return dao.getAllStudents();
    }

    @Override
    public String toString() {
        return "StudentServiceImpl [dao=" + dao + "]";
    }
}
