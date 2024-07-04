package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.model.Student;


public class TestApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		id=18;
		try {
			Configuration configuration = new Configuration();
			configuration.setProperties(null);
			
			Student student = session.get(Student.class, id);
			
			if(student != null) {
				System.out.println("Before updation in the table :: "+student);
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
		}

	}

}
