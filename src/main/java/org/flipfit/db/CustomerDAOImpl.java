package org.flipfit.db;

import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.flipfit.core.Booking;
import org.flipfit.core.Customer;
import org.flipfit.core.GymCenter;
import org.flipfit.core.Slot;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class CustomerDAOImpl extends AbstractDAO<Customer> implements CustomerDAOInterface {

    @Inject
    public CustomerDAOImpl(SessionFactory sessionFactory) {super(sessionFactory);}

    public Customer register(Customer customer) {
        return persist(customer);
    }

    public List<GymCenter> getGymInCity(String city){
        return null;
    }

    public List<Slot> getSlotInGym(String gymId){
        return null;
    }

    public boolean isSlotBooked(String slotId, Date date){
        return false;
    }

    public int bookSlot(String gymId, String slotId, String email, Date date){
        return 0;
    }

    public List<Booking> getBookings(String email){
        return null;
    }

    public boolean cancelBooking(String bookingId, String email){
        return false;
    }
}
