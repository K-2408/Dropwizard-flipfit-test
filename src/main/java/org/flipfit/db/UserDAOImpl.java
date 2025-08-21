package org.flipfit.db;

import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.flipfit.core.Customer;
import org.flipfit.core.GymOwner;
import org.flipfit.core.User;
import org.hibernate.SessionFactory;

public class UserDAOImpl extends AbstractDAO<User>  implements UserDAOInterface {

    @Inject
    public UserDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public boolean registerCustomer(Customer customer) {
        return false;
    }

    public boolean authenticateUser(User user) {
        return false;
    }

    public boolean editProfile(Customer customer) {
        return false;
    }

    public boolean registerGymOwner(GymOwner gymOwner) {
        return false;
    }

    public GymOwner getGymOwnerDetails(String gymOwnerEmailId) {
        return null;
    }

    public void editGymOwnerDetails(GymOwner gymOwnerDetails) {

    }
}
