package co.edu.uptc.sw2.proyectofinalfotos.logic;

import co.edu.uptc.sw2.proyectofinalfotos.entities.EnumStatus;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Photographer;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Proyect;
import co.edu.uptc.sw2.proyectofinalfotos.persistence.PhotoDAO;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PhotoLogic {
 
    @EJB
    private PhotoDAO photoDAO;
    
    @EJB
    private ProjectLogic projectLogic;
    
    @EJB
    private PhotographerLogic photographerLogic;
    
    public List<Photo> getPhotos(){
        return photoDAO.getPhotos();
    }
    
    public List<Photo> getPhotos(int idProject){
        List<Photo> photos = projectLogic.getProject(idProject).getListPhotos();
        photos.sort(new Comparator<Photo>() {
            @Override
            public int compare(Photo photo1, Photo photo2) {
                return photo2.getDate().compareTo(photo1.getDate());
            };
        });
        return photos;
    }

    public List<Photo> getPhotos(EnumStatus enumStatus) {
        return photoDAO.getPhotos(enumStatus);
    }
    
    public void update(Photo photo) {
        photoDAO.update(photo);
    }

    public void addPhoto(int idProject, Photo photo) {
        photo.setEnumStatus(EnumStatus.IN_PROCESS);
        Photographer photographer = photographerLogic.getPhotographer(photo.getPhotographer().getEmailP());
        if (photographer != null) {
            photo.setPhotographer(photographer);
        }
        Proyect proyect = projectLogic.getProject(idProject);
        if (proyect.getListPhotos() == null) {
            proyect.setListPhotos(new ArrayList<Photo>());
        }
        proyect.getListPhotos().add(photo);
        projectLogic.updateProject(proyect);
    }
}