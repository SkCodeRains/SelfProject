package ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {
		Laptop laptop = new Laptop();
		laptop.setLid(1011);
		laptop.setLname("dell");
		Student s = new Student();
		s.setName("king");
		s.setRollno(11);
		s.setMarks(100);
		s.getLaptop().add(laptop);

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();

		ss.beginTransaction();
		ss.save(laptop);
		ss.save(s);
		ss.getTransaction().commit();
	}

}
