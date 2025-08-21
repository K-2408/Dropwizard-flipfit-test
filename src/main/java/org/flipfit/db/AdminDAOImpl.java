package org.flipfit.db;

import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.flipfit.core.Admin;
import org.flipfit.core.GymCenter;
import org.flipfit.core.GymOwner;
import org.hibernate.SessionFactory;

import java.util.List;

public class AdminDAOImpl  extends AbstractDAO<Admin> implements AdminDAOInterface {

    @Inject
    public AdminDAOImpl(SessionFactory sessionFactory) {super(sessionFactory);}

    public Admin register(Admin admin) {
        return persist(admin);
    }

    public List<GymOwner> getAllGymOwners(){
        return null;
    }

    public List<GymCenter> getAllGyms(){
        return null;
    }

    public List<GymOwner> getPendingGymOwnerRequests(){
        return null;
    }

    public List<GymCenter> getPendingGymRequests(){
        return null;
    }

    public void approveSingleOwnerRequest(String gymOwnerEmail){

    }

    public void approveAllOwnerRequest(){

    }

    public void approveSingleGymRequest(String gymId){

    }

    public void approveAllGymRequest(){

    }


}
