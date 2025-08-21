package org.flipfit.db;

import org.flipfit.core.Booking;
import org.flipfit.core.Customer;
import org.flipfit.core.GymCenter;
import org.flipfit.core.Slot;

import java.util.Date;
import java.util.List;

public interface CustomerDAOInterface {

    Customer register(Customer customer);

    List<GymCenter> getGymInCity(String city);

    List<Slot> getSlotInGym(String gymId);

    boolean isSlotBooked(String slotId, Date date);

    int bookSlot(String gymId, String slotId, String email, Date date);

    List<Booking> getBookings(String email);

    boolean cancelBooking(String bookingId, String email);
}
