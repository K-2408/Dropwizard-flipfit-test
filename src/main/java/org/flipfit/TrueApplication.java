package org.flipfit;

//import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.core.Application;
import io.dropwizard.core.ConfiguredBundle;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import jakarta.persistence.Entity;
import org.flipfit.resources.AdminResource;
import org.flipfit.resources.CustomerResource;
import org.flipfit.resources.GymOwnerResource;
import org.reflections.Reflections;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import java.util.Arrays;
import java.util.Set;

public class TrueApplication extends Application<TrueConfiguration> {

    //to find all the entity classes
    private static Class<?>[] findEntityClasses(String packageName) {
        Reflections reflections = new Reflections(packageName);
        Set<Class<?>> entityClasses = reflections.getTypesAnnotatedWith(Entity.class);

        // HibernateBundle requires at least one entity. Fail fast if none are found.
        if (entityClasses.isEmpty()) {
            throw new IllegalStateException("No classes annotated with @Entity found in package: " + packageName);
        }
        return entityClasses.toArray(new Class<?>[0]);
    }

    // 2. Store the discovered entity classes in a static final array.
    private static final Class<?>[] ENTITY_CLASSES = findEntityClasses("org.flipfit.core");

    // 3. Initialize the HibernateBundle using the required constructor signature.
    private final HibernateBundle<TrueConfiguration> hibernateBundle =
            new HibernateBundle<TrueConfiguration>(
                    ENTITY_CLASSES[0], // Provide the first class from the array.
                    // Provide the rest of the classes from the array for the varargs parameter.
                    Arrays.copyOfRange(ENTITY_CLASSES, 1, ENTITY_CLASSES.length)
            ) {
                @Override
                public DataSourceFactory getDataSourceFactory(TrueConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    private GuiceBundle guiceBundle;
    public static void main(final String[] args) throws Exception {
        new TrueApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<TrueConfiguration> bootstrap) {
        AppModule appModule = new AppModule(hibernateBundle);

        // Specify the configuration type on the builder
        guiceBundle = GuiceBundle.builder()
                .modules(appModule) // Use .modules() to add your Guice module(s)
                .enableAutoConfig(getClass().getPackage().getName()) // This scans for resources, etc.
                .build();

        bootstrap.addBundle(hibernateBundle);
        // The explicit cast is often no longer needed
        bootstrap.addBundle(guiceBundle);
    }



    @Override
    public void run(final TrueConfiguration configuration,
                    final Environment environment) {
        final CustomerResource customerResource = guiceBundle.getInjector().getInstance(CustomerResource.class);
        environment.jersey().register(customerResource);
        final AdminResource adminResource = guiceBundle.getInjector().getInstance(AdminResource.class);
        environment.jersey().register(adminResource);
        final GymOwnerResource gymResource = guiceBundle.getInjector().getInstance(GymOwnerResource.class);
        environment.jersey().register(gymResource);
    }

}
