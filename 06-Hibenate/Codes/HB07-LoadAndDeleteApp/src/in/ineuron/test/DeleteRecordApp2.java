package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class DeleteRecordApp2 {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		try {
			session = HibernateUtil.getSession();
			id = 121;
			Student student = session.get(Student.class, id);
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				if(student!=null) {
					session.delete(student);
					flag = true;
				}else {
					System.out.println("RECORD NOT AVAILABLE FOR DELETION..:: "+id);
				}
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
