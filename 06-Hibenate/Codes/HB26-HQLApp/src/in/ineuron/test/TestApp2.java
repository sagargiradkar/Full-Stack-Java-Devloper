package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// Prepare Query object to hold HQL
			Query<Object[]> query = session.createQuery("SELECT price,qty FROM in.ineuron.model.Product WHERE pname IN(:prod1,:prod2");// select * from product;
			

			query.setParameter("prod1", "fossils");
			query.setParameter("prod2", "tissit");
			// Execute the query
			List<Object[]> products = query.list();
			
			System.out.println("PRICE\tQTY");
			// process the List Object
			products.forEach(row->{
				
				for(Object object:row) {
					System.out.print(object +"\t");
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
