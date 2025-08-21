package org.flipfit.resources;

import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import org.flipfit.core.Booking;
import org.flipfit.core.Customer;
import org.flipfit.core.GymCenter;
import org.flipfit.core.Slot;
import org.flipfit.db.CustomerDAOImpl;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.flipfit.db.UserDAOImpl;

import java.util.Date;
import java.util.List;

@Path("/customer")
public class CustomerResource {
    @Inject
    UserDAOImpl userDAO;

    @Inject
    CustomerDAOImpl customerDao ;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Customer register(Customer customer) {
        return customerDao.register(customer);
    }
    /**
     * Obtains all the gyms for the given city.
     * @param city the city name for which the gym list is requested
     * @return returns List of gyms available for the given city
     */
    public List<GymCenter> getGymInCity(String city) {
        return customerDao.getGymInCity(city);
    }
    /**
     * Obtains all the slots for the given gymId.
     * @param gymId the Gym Id for which the slot details are requested
     * @return returns List of available slots for the given gymId
     */
    public List<Slot> getSlotInGym(String gymId) {
        return customerDao.getSlotInGym(gymId);
    }
    /**
     * Checks if the slot is already booked or not
     * @param slotId the slot id for which the booking status is requested
     * @param date the date on which the booking status is requested
     * @return returns true if the slot id for the given date is fully booked else returns false
     */
    public boolean isSlotBooked(String slotId, Date date) {
        return customerDao.isSlotBooked(slotId, date);
    }


    public int bookSlot (String gymId, String slotId, String email, Date date){
        return customerDao.bookSlot(gymId, slotId, email, date);
    }

    public List<Booking> getBookings(String email){
        return customerDao.getBookings(email);
    }

    public boolean cancelBooking(String bookingId, String email){
        return customerDao.cancelBooking(bookingId, email);
    }

}
