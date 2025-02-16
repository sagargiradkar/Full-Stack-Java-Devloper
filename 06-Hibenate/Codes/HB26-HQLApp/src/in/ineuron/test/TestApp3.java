package in.ineuron.test;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp3 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();

			// Prepare Query object to hold HQL
			Query<Product> query = session.createQuery("FROM in.ineuron.model.Product WHERE pid:=id");
		
			
			System.out.println("Enter the id of the product to be fetched ::");
			int id = new Scanner(System.in).nextInt();
			
			query.setParameter("id", id);
			
			// Execute the query
			Optional<Product> optional = query.uniqueResultOptional();
			if(optional.isPresent()) {
				Product product = optional.get();
				System.out.println(product);
			}else {
				System.out.println("Record not available for given id ::"+id);
			}
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
