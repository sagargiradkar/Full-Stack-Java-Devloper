package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PersonInfo;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				int id = 1;
				PersonInfo personInfo = session.get(PersonInfo.class, id);
				if (personInfo != null) {
					System.out.println(personInfo);
				}else {
					System.out.println("RECORD NOT AVAILABLE FOR THE GIVEN ID ::" +id);
				}
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
