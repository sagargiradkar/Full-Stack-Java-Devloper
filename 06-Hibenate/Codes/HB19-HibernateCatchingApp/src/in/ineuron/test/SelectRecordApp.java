package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		InsurancePolicy policy = null;
		
		try {
			session = HibernateUtil.getSession();
			
			policy = session.get(InsurancePolicy.class, 1L);
			System.out.println("1 :: " +policy);
			System.out.println("===========================================================");
			
			policy = session.get(InsurancePolicy.class, 1L);
			System.out.println("2 :: "+policy);
			System.out.println("===========================================================");
			
			session.evict(policy);
			
			policy = session.get(InsurancePolicy.class, 1L);
			System.out.println("3 :: "+policy);
			System.out.println("===========================================================");
			
			policy = session.get(InsurancePolicy.class, 1L);
			System.out.println("4 :: "+policy);
			System.out.println("===========================================================");
			
			
			
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
