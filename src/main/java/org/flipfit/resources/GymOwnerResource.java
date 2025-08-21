package org.flipfit.resources;

import io.dropwizard.hibernate.UnitOfWork;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.flipfit.core.GymCenter;
import org.flipfit.core.GymOwner;
import org.flipfit.core.Slot;
import org.flipfit.db.GymOwnerDAOImpl;
import org.flipfit.db.UserDAOImpl;

import jakarta.inject.Inject;
import java.util.List;

@Path("/gymOwner")
public class GymOwnerResource {
        @Inject
        UserDAOImpl userDAO;

        @Inject
        GymOwnerDAOImpl gymOwnerDAO;


        @POST
        @Path("/register")
        @Consumes(MediaType.APPLICATION_JSON)
        @UnitOfWork
        public GymOwner register(GymOwner gymOwner){
            return gymOwnerDAO.register(gymOwner);
        }

        public GymOwner getProfile(String email) {
            System.out.println("Fetched Gym owner details successfully! " + email);
            return userDAO.getGymOwnerDetails(email);
        }
        public void editProfile(GymOwner gymOwnerNew) {
            userDAO.editGymOwnerDetails(gymOwnerNew);
            System.out.println("\nEdited your profile Successfully!");
        }
        public boolean addGym(GymCenter gym) {
            gymOwnerDAO.addGym(gym);
            System.out.println("\nAdded Gym Successfully!" + gym.getGymId());
            return true;
        }
        public void editGym(GymCenter gym) {
            gymOwnerDAO.editGym(gym);
            System.out.println("\nEdited Gym Details Successfully! ");
        }
        public void addSlot(Slot slot) {
            gymOwnerDAO.addSlot(slot);
            System.out.println("\nAdded slot successfully!");
        }
        public List<GymCenter> getGymDetail(String gymOwnerEmail) {
            System.out.println("\nFetched gym details successfully! " + gymOwnerEmail);
            return gymOwnerDAO.getGymsOfGymOwner(gymOwnerEmail);
        }
}
