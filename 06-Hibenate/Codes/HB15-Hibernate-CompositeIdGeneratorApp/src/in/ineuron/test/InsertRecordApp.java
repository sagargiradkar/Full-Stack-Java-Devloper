package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.PogrammerId;
import in.ineuron.model.ProgrammerProjectInfo;
import in.ineuron.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		PogrammerId pk = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				PogrammerId projId =  new PogrammerId();
				projId.setPid(100);
				projId.setProjID(501);
				
				
				ProgrammerProjectInfo info = new ProgrammerProjectInfo();
				
				info.setId(projId);
				info.setDeptNo(10);
				info.setPname("IPL");
				
				pk =  (PogrammerId) session.save(info);
				
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("OBJECT INSERTED TO DATABASE....WITH THE ID :: "+pk);
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
