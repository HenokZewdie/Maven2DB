package MavenDB.config;

import MavenDB.model.Contacts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Handler {

    public void insertIntoDB(Contacts contacts){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(contacts);
        session.getTransaction().commit();
        session.close();
    }
}
