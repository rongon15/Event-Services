package com.ecommerce.users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.engine.spi.SessionImplementor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SessionManager {

    @PersistenceContext
    private EntityManager entityManager;

    public Session getSession()
    {
        return entityManager.unwrap(SessionImplementor.class).getFactory().getCurrentSession();
    }

    public StatelessSession getStatelessSession(){
        return entityManager.unwrap(SessionImplementor.class).getFactory().openStatelessSession();
    }

    public SessionFactory sessionFactory(){
        SessionFactory sessionFactory=entityManager.unwrap(SessionImplementor.class).getFactory();
        if (sessionFactory == null){
            throw new IllegalStateException("Session Factory has not been set on DAO on usage");
        }
        return sessionFactory;
    }
}
