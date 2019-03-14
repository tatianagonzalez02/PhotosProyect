package co.edu.uptc.sw2.proyectofinalfotos.persistence;

import co.edu.uptc.sw2.proyectofinalfotos.entities.EnumStatus;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PhotoDAO {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Photo> getPhotos(){
        return entityManager.createNamedQuery("getPhotos", Photo.class).getResultList();
    }
    
    public List<Photo> getPhotos(EnumStatus enumStatus) {
        return entityManager.createNamedQuery("getPhotosByStatus", Photo.class).setParameter("enumStatus", enumStatus).getResultList();
    }
    
    public void update(Photo photo) {
        entityManager.merge(photo);
    }
}
