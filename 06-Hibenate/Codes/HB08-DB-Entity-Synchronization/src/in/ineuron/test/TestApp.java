package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		try {
			id=18;
			session = HibernateUtil.getSession();
			Student student = session.get(Student.class, id);
			System.out.println("Before updation in the table :: "+student);
			
			if(student != null) {
				System.in.read();
				session.refresh(student);
				System.out.println("After updation in the table :: "+student);
			}else {
				System.out.println("Record available for the given id :: "+id);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object delete from database....");
			} else {
				transaction.rollback();
				System.out.println("Object not deleted from database...");
				
			}

			System.in.read();
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
