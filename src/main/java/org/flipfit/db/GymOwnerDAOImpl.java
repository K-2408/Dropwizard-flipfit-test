package org.flipfit.db;

import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.flipfit.core.GymCenter;
import org.flipfit.core.GymOwner;
import org.flipfit.core.Slot;
import org.hibernate.Incubating;
import org.hibernate.SessionFactory;

import java.util.List;

public class GymOwnerDAOImpl extends AbstractDAO<GymOwner> implements GymOwnerDAOInterface {
    @Inject
    GymOwnerDAOImpl(SessionFactory sessionFactory) {super(sessionFactory);}

    @Override
    public GymOwner register(GymOwner gymOwner) {
        return persist(gymOwner);
    }

    public void addGym(GymCenter gymDetails) {

    }

    public void editGym(GymCenter gymDetails) {

    }

    public void addSlot(Slot slot) {

    }

    public List<GymCenter> getGymsOfGymOwner(String gymOwnerEmail) {
        return null;
    }
}
