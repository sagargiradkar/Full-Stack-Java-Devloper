package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.util.HibernateUtil;

public class SelectApp {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
	
		try {
			session = HibernateUtil.getSession();
			
			NativeQuery<Object[]> nativeQuery = session.getNamedNativeQuery("GET_ALL_POLICIES_TYPE");
			
			nativeQuery.setParameter(1, "quaterly");
			List<Object[]> policies =  nativeQuery.getResultList();
			
			policies.forEach(row ->{
				for(Object object : row) {
					System.out.println(object+"\t");
				}
				System.out.println();
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
