package de.spring.util;

import org.hibernate.Session;

public interface SessionFactoryIF {

    Session getCurrentSession();

    Session openNewSession();

    void closeFactory();

    boolean isClosed();


}
