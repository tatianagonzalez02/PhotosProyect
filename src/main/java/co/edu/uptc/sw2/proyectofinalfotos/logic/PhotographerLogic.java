package co.edu.uptc.sw2.proyectofinalfotos.logic;

import co.edu.uptc.sw2.proyectofinalfotos.persistence.PhotographerDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PhotographerLogic {
    
    @EJB
    private PhotographerDAO pdao;
    
    public String getPhotographer(String email) {
        return pdao.getPhotographer(email);
    }
    
}