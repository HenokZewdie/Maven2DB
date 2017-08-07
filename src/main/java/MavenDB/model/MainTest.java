package MavenDB.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainTest {
    public void process (){
        Contacts contacts = new Contacts();
        contacts.setFname("Mena");
        contacts.setLname("Henok");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(contacts);
        session.getTransaction().commit();
        session.close();
        System.out.println("Transaction started");
    }
}
