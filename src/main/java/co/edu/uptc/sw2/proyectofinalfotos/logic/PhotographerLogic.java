package co.edu.uptc.sw2.proyectofinalfotos.logic;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Photographer;
import co.edu.uptc.sw2.proyectofinalfotos.persistence.PhotographerDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PhotographerLogic {
    
    @EJB
    private PhotographerDAO photographerDAO;
    
    public Photographer getPhotographer(String email) {
        return photographerDAO.getPhotographer(email);
    }
    
}