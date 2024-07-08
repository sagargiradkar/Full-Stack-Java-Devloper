package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class LoadandMergeApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		Student student = null;
		Student std = null;
		
		try {
			
			session = HibernateUtil.getSession();
			student = session.get(Student.class, 5);
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				std = new Student();
				std.setSid(5);
				std.setSaddress("SuryakumerYadav");
				std.setSage(32);
				session.merge(std);
				flag = true;
			
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated to database....");
			} else {
				transaction.rollback();
				System.out.println("Object not updated to database...");
				
			}

			System.in.read();
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
