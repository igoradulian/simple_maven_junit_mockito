package org.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Igor Adulyan
 * Connection factory singletone
 * This implementation needed in
 * order correctly run application
 * with single instance of Session
 * and avoid problems with deattched
 * entites
 */
public enum ConnectionFactory {
    GET_SESSION(),
    CLOSE_SESSION();

    private SessionFactory factory;
    private Session session;
    private Transaction t;

    private ConnectionFactory() {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        session = factory.openSession();
        t = session.beginTransaction();
    }

    public ConnectionFactory getInstance()
    {
        return GET_SESSION;
    }

    public Session getSession()
    {
        return session;
    }

    public void closeSession()
    {
        t.commit();
        factory.close();
        session.close();
    }
}
