package co.edu.uptc.sw2.proyectofinalfotos.services;

import co.edu.uptc.sw2.proyectofinalfotos.logic.PhotographerLogic;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("PhotographerService")
public class PhotographerService {
    
    @EJB
    private PhotographerLogic photographerLogic;
    
    @GET
    @Path("/{email}")
    public String getCompany(@PathParam("email") String email){
        return photographerLogic.getPhotographer(email);
    }
    
}
