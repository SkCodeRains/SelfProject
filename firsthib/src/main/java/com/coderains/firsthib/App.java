package com.coderains.firsthib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		alienName an = new alienName();
		an.setFname("mohammed");
		an.setMname("abdullah");
		an.setLname("shaikh");
		alien coderains = new alien();
		coderains.setAid(1011);
		coderains.setAname(an);
		coderains.setColor("red");

		Configuration con = new Configuration().configure().addAnnotatedClass(alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session ss = sf.openSession();

		Transaction tx = ss.beginTransaction();
		ss.save(coderains);
		tx.commit();

	}
}
