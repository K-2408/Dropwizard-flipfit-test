package org.flipfit.resources;

import io.dropwizard.hibernate.UnitOfWork;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.flipfit.core.Admin;
import org.flipfit.core.GymCenter;
import org.flipfit.core.GymOwner;
import org.flipfit.db.AdminDAOImpl;
import org.flipfit.db.UserDAOImpl;
import org.hibernate.Incubating;

import jakarta.inject.Inject;
import java.util.List;


@Path("/admin")
public class AdminResource {

    @Inject
    UserDAOImpl userDAO;

    @Inject
    AdminDAOImpl adminDAO;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Admin register(Admin admin) {
        return adminDAO.register(admin);
    }
    /**
     * Obtains a list of every gym owner within the system.
     * @return List of GymOwner objects
     */
    public List<GymOwner> getGymOwners() {
        System.out.println("Fetched gym owner details successfully!");
        return adminDAO.getAllGymOwners();
    }
    /**
     * Obtains a list of every gym within the system.
     * @return List of Gym objects
     */
    public List<GymCenter> getGym() {
        System.out.println("Fetched gym details successfully!");
        return adminDAO.getAllGyms();
    }
    /**
     * Returns all GymOwners object whose requests are pending for approval.
     * @return List of GymOwner objects
     */
    public List<GymOwner> viewAllPendingGymOwnerRequests() {
        System.out.println("Fetched pending gym owner details successfully!");
        return adminDAO.getPendingGymOwnerRequests();
    }

    /**
     * Accepts one request from a gym owner.
     * @param gymOwnerEmail The request's email that has to be approved
     */
    public boolean approveSingleGymOwnerRequest(String gymOwnerEmail) {
        adminDAO.approveSingleOwnerRequest(gymOwnerEmail);
        System.out.println("Approved gym owner request! " + gymOwnerEmail);
        return true;
    }

    /**
     * Approves all GymOwners whose requests are pending for approval.
     */
    public boolean approveAllPendingGymOwnerRequests() {
        adminDAO.approveAllOwnerRequest();
        System.out.println("Approved all pending gym owner requests!");
        return true;
    }
    /**
     * Returns all Gym object whose requests are pending for approval.
     * @return List of Gym objects
     */
    public List<GymCenter> viewAllPendingGymRequests() {
        System.out.println("Fetched pending gym requests successfully!");
        return adminDAO.getPendingGymRequests();
    }
    /**
     * Approves a single Gym object request.
     * @param gymId the id of a gym that needs to be approved
     * @return true if the gymId is valid else returns false
     */
    public boolean approveSingleGymRequest(String gymId) {
        adminDAO.approveSingleGymRequest(gymId);
        System.out.println("Successfully approved gym request! " + gymId);
        return true;
    }
    /**
     * Approves all Gym whose requests are pending for approval.
     */
    public boolean approveAllPendingGymRequests() {
        adminDAO.approveAllGymRequest();
        System.out.println("Successfully approved all pending gym requests!");
        return true;
    }
}
