package in.ineuron.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import in.ineuron.bo.StudentBO;

@Repository
public class StudentDaoImpl implements IStudentDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    @Override
    @Transactional
    public int insert(StudentBO s) {
        Integer id = (Integer) hibernateTemplate.save(s);
        return id;
    }

    @Override
    @Transactional
    public void delete(int id) {
        StudentBO student = hibernateTemplate.get(StudentBO.class, id);
        if (student != null) {
            hibernateTemplate.delete(student);
        }
    }

    @Override
    @Transactional
    public void delete(StudentBO s) {
        hibernateTemplate.delete(s);
    }

    @Override
    @Transactional
    public void update(StudentBO s) {
        hibernateTemplate.update(s);
    }

    @Override
    public StudentBO getStudent(int id) {
        return hibernateTemplate.get(StudentBO.class, id);
    }

    @Override
    public List<StudentBO> getAllStudents() {
        return hibernateTemplate.loadAll(StudentBO.class);
    }

    @Override
    public String toString() {
        return "StudentDaoImpl [hibernateTemplate=" + hibernateTemplate + "]";
    }
}
