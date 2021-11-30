package com.coderains.firsthib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class fetch {

	public static void main(String[] args) {
		alien coderains = new alien();

		Configuration con = new Configuration().configure().addAnnotatedClass(alien.class);

		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);

		Session ss = sf.openSession();

		ss.beginTransaction();

		coderains = ss.get(alien.class, 1011);

		ss.save(coderains);

		System.out.print(coderains);
	}

}
