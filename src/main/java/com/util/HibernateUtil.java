package com.util;

import com.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private final static SessionFactory sessionFactory=buildSessionFactory();
    private static SessionFactory buildSessionFactory()
    {

        try {
            return new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Character.class)
                    .addAnnotatedClass(FieldModel.class)
                    .addAnnotatedClass(FieldModelSubject.class)
                    .addAnnotatedClass(FieldModelSubjectChapter.class)
                    .addAnnotatedClass(Subject.class)
                    .addAnnotatedClass(Question.class)
                    .buildSessionFactory();

        }catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession()
    {
        return getSessionFactory().openSession(); //session opened
    }
}
