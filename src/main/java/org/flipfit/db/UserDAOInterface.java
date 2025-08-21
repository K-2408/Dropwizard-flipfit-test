package org.flipfit.db;

import org.flipfit.core.Customer;
import org.flipfit.core.GymOwner;
import org.flipfit.core.User;

public interface UserDAOInterface {

    boolean registerCustomer(Customer customer);

    boolean authenticateUser(User user);

    boolean editProfile(Customer customer);

    boolean registerGymOwner(GymOwner gymOwner);

    GymOwner getGymOwnerDetails(String gymOwnerEmailId);

    void editGymOwnerDetails(GymOwner gymOwnerDetails);
}
