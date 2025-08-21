package org.flipfit;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.HibernateBundle;
import org.flipfit.db.*;
import org.hibernate.SessionFactory;

public class AppModule extends AbstractModule {
    private final HibernateBundle<TrueConfiguration> hibernateBundle;

    public AppModule(HibernateBundle<TrueConfiguration> hibernateBundle) {
        this.hibernateBundle = hibernateBundle;
    }

    @Override
    protected void configure() {
        // Bind the interface to its implementation.
        // Guice will now know to create a CustomerDAOImpl when CustomerDAOInterface is needed.
        bind(CustomerDAOInterface.class).to(CustomerDAOImpl.class);
        bind(AdminDAOInterface.class).to(AdminDAOImpl.class);
        bind(GymOwnerDAOInterface.class).to(GymOwnerDAOImpl.class);
        // Guice will automatically see that CustomerDAOImpl needs a SessionFactory
        // and will use the @Provides method below to get it.
    }

    @Provides // A provider method tells Guice how to create an object
    @Singleton // Ensures only one instance is created
    public SessionFactory provideSessionFactory() {
        return hibernateBundle.getSessionFactory();
    }
//
//    @Provides
//    @Singleton
//    public UserDAOImpl provideStudentDAO(SessionFactory sessionFactory) {
//        return new UserDAOImpl(sessionFactory);
//    }
//
//    @Provides
//    @Singleton
//    public CourseDAO provideCourseDAO(SessionFactory sessionFactory) {
//        return new CourseDAO(sessionFactory);
//    }
}
