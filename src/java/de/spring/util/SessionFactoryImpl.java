package de.spring.util;

import de.spring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Qualifier("sessionFactory")
public class SessionFactoryImpl implements SessionFactoryIF{

    private SessionFactory factory;
    private Configuration config;

    @Autowired
    private SessionFactoryImpl() {
        enableHibernateXMLFile();
        addEntities();
        buildSessionFactory();
    }

    private void enableHibernateXMLFile() {
        config = new Configuration().configure("hibernate.cfg.xml");
    }

    private void addEntities() {
        config.addAnnotatedClass(User.class);
    }

    private void buildSessionFactory() {
        factory = config.buildSessionFactory();
    }

    @Override
    public Session getCurrentSession() {
        return factory.getCurrentSession();
    }

    @Override
    public Session openNewSession() {
        return factory.openSession();
    }

    @Override
    public void closeFactory() {
        factory.close();
    }

    @Override
    public boolean isClosed() {
        return factory.isClosed();
    }
}
