package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class GetRecordApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		int id = 13;
 		try {
			session = HibernateUtil.getSession();
			
			if(session != null) {
				Student student = session.get(Student.class, id);
				if(student != null) {
					System.out.println(student);
				}else {
					System.out.println("Record not found for the given record :: "+id);
				}
			}
			

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
