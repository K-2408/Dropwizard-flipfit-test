package org.flipfit.resources;

import org.flipfit.core.Customer;
import org.flipfit.core.GymOwner;
import org.flipfit.core.User;
import org.flipfit.db.UserDAOImpl;

import jakarta.inject.Inject;

public class UserResource {

        @Inject
        UserDAOImpl userDao;
        /**
         Registers a customer in the system.
         @param customer The Customer object representing the customer data
         */
        public boolean registerCustomer(Customer customer) {
            boolean registerSuccess = false;
            registerSuccess = userDao.registerCustomer(customer);
            return registerSuccess;
        }
        /**
         Verifies a user's data.
         @param user The user object representing the user data
         @return true if the user's data are valid else returns false
         */
        public boolean authenticateUser(User user) {
            boolean authenticateSuccess = false;
            authenticateSuccess = userDao.authenticateUser(user);
            return authenticateSuccess;
        }

        public boolean editProfile(Customer customer) {
            boolean editSuccess = false;
            editSuccess = userDao.editProfile(customer);
            return editSuccess;
        }

        public boolean registerGymOwner(GymOwner gymOwner) {
            boolean registerSuccess = false;
            registerSuccess = userDao.registerGymOwner(gymOwner);
            return registerSuccess;
        }
}
