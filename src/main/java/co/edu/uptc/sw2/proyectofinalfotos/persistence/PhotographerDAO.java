package co.edu.uptc.sw2.proyectofinalfotos.persistence;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Photographer;
import co.edu.uptc.sw2.proyectofinalfotos.errors.ErrorPhotographer;
import com.google.gson.Gson;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PhotographerDAO {

    @PersistenceContext
    private EntityManager entityManager;
    private static final ErrorPhotographer ERROR_PHOTOGRAPHER = new ErrorPhotographer(0, "Datos erroneos");
    private static final Gson GSON = new Gson();

    public Photographer getPhotographer(String email) {
        try {
            return entityManager.createNamedQuery("getPhotographer", Photographer.class).setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            return null;
        }
//        try {
//            Query query = entityManager.createNamedQuery("getPhotographer", Photographer.class);
//            query.setParameter("email", email);
//            return GSON.toJson(query.getSingleResult());
//        } catch (Exception e) {
//            System.out.println("No hay datos" + e);
//        }
//        return GSON.toJson(ERROR_PHOTOGRAPHER);
//    }

}}
