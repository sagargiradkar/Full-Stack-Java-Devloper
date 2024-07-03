package in.ineuron.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;

public class TestApp {

    public static void main(String[] args) {
        // 1. Inform JVM to activate HIBERNATE
        Configuration configuration = new Configuration();
        configuration.configure(); // by default reads hibernate.cfg.xml from classpath

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // 2. Create PERSISTENCE Object
            Student student = new Student();
            student.setSid(10);
            student.setSname("SAGAR");
            student.setSaddress("RCB");
            student.setSage(26);

            // 3. Perform Persistence operation using Entity/Model/POJO Object
            session.save(student);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
