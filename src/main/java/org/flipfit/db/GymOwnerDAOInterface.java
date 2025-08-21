package org.flipfit.db;

import org.flipfit.core.GymCenter;
import org.flipfit.core.GymOwner;
import org.flipfit.core.Slot;

import java.util.List;

public interface GymOwnerDAOInterface {
    GymOwner register(GymOwner gymOwner);
    void addGym(GymCenter gymDetails);

    void editGym(GymCenter gymDetails);

    void addSlot(Slot slot);

    List<GymCenter> getGymsOfGymOwner(String gymOwnerEmail);
}
