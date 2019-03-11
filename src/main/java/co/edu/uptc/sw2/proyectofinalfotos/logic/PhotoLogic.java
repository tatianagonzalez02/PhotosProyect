package co.edu.uptc.sw2.proyectofinalfotos.logic;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import co.edu.uptc.sw2.proyectofinalfotos.persistence.PhotoDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author FREDY
 */
@Stateless
public class PhotoLogic {
 
    @EJB
    private PhotoDAO photoDAO;
    
    public List<Photo> getPhotos(){
        return photoDAO.getPhotos();
    }

    public void update(Photo photo) {
        photoDAO.update(photo);
    }
}