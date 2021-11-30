package fetchingEL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class)
				.addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session ss = sf.openSession();

		ss.beginTransaction();
		Alien a1 = ss.get(Alien.class, 1);
		System.out.println(a1);
		/*
		 * Collection<Laptop> laps = a1.getLaps(); for (Laptop l : laps) {
		 * System.out.println(l); }
		 */
		ss.getTransaction().commit();
	}

}
