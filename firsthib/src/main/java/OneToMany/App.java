package OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {
		Laptop laptop = new Laptop();
		laptop.setLid(101);
		laptop.setLname("dell");
		Student student = new Student();
		student.setName("king");
		student.setRollno(1);
		student.setMarks(100);
		student.getLaptop().add(laptop);

		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session ss = sf.openSession();

		ss.beginTransaction();
		ss.save(laptop);
		ss.save(student);
		ss.getTransaction().commit();
	}

}
