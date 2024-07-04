package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class UpdateRecord2 {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		try {
			session = HibernateUtil.getSession();
			Student student = session.get(Student.class, 109);

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				if(student!=null) {
					System.out.println(student);
					System.out.println();
					
					student.setSaddress("RCB");
					session.update(student);
					 
					flag = true;
				}else {
					System.out.println("RECORD NOT AVAILABLE FOR UPDATION..");
				}
				
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
