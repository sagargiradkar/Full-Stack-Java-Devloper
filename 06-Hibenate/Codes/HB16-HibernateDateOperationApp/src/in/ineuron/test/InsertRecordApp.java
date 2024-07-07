package in.ineuron.test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				
				PersonInfo personInfo = new PersonInfo();
				personInfo.setPname("SACHiN");
				personInfo.setDob(LocalDate.of(1973, 04, 24));
				personInfo.setDom(LocalDateTime.of(1995, 5,25,7,45));
				personInfo.setDoj(LocalTime.of(9, 15));
				
			
				id = (Integer) session.save(personInfo);
				
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("OBJECT INSERTED TO DATABASE....WITH THE ID :: ");
			} else {
				transaction.rollback();
				System.out.println("OBJECT NOT INSERTED TO DATABASE...");
				
			}

			System.in.read();
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
