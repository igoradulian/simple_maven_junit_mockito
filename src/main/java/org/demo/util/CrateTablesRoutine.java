package org.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Igor Adulyan
 */
public class CrateTablesRoutine {

    public static final void createTables()
    {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        t.commit();
        factory.close();
        session.close();
    }
}
