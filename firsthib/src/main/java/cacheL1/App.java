package cacheL1;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	public static void main(String[] args) {
		alien_table coderains = new alien_table();

		Configuration con = new Configuration().configure().addAnnotatedClass(alien_table.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);

		Session ss = sf.openSession();
		ss.beginTransaction();
		Query q1 = ss.createQuery("from alien_table where aid=101");
		coderains = (alien_table) q1.uniqueResult();
		System.out.println(coderains);
		ss.getTransaction().commit();

		Session sss = sf.openSession();
		sss.beginTransaction();
		Query q2 = sss.createQuery("from alien_table where aid=101");
		coderains = (alien_table) q2.uniqueResult();
		System.out.println(coderains);
		sss.getTransaction().commit();

	}

}
