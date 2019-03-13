package co.edu.uptc.sw2.proyectofinalfotos.logic;

import co.edu.uptc.sw2.proyectofinalfotos.entities.EnumStatus;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Proyect;
import co.edu.uptc.sw2.proyectofinalfotos.persistence.PhotoDAO;
import java.util.ArrayList;
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
    
    @EJB
    private ProjectLogic projectLogic;
    
    public List<Photo> getPhotos(){
        return photoDAO.getPhotos();
    }

    public List<Photo> getPhotos(EnumStatus enumStatus) {
        return photoDAO.getPhotos(enumStatus);
    }
    
    public void update(Photo photo) {
        photoDAO.update(photo);
    }

    public void addPhoto(int idProject, Photo photo) {
        photo.setEnumStatus(EnumStatus.IN_PROCESS);
        Proyect proyect = projectLogic.getProject(idProject);
        if (proyect.getListPhotos() == null) {
            proyect.setListPhotos(new ArrayList<Photo>());
        }
        proyect.getListPhotos().add(photo);
        projectLogic.updateProject(proyect);
    }
}