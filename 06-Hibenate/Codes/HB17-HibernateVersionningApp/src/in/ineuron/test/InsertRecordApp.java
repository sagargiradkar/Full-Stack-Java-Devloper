package in.ineuron.test;

import java.io.IOException;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
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
				MobileCustomer customer = new MobileCustomer();
				customer.setCname("SmrithiMandana");
				customer.setMobileNo(9168801192L);
				customer.setCtune("RCB RCB ....");
				
				id = (Integer) session.save(customer);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("OBJECT INSERTED TO DATABASE....WITH THE ID :: "+id);
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
