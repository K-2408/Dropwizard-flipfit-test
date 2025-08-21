package org.flipfit.db;

import org.flipfit.core.Admin;
import org.flipfit.core.GymCenter;
import org.flipfit.core.GymOwner;
import java.util.List;

public interface AdminDAOInterface {
    Admin register(Admin admin);
    List<GymOwner> getAllGymOwners();

    List<GymCenter> getAllGyms();

    List<GymOwner> getPendingGymOwnerRequests();

    List<GymCenter> getPendingGymRequests();

    void approveSingleOwnerRequest(String gymOwnerEmail);

    void approveAllOwnerRequest();

    void approveSingleGymRequest(String gymId);

    void approveAllGymRequest();
}
