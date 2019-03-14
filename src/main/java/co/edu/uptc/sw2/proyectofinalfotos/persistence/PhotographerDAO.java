package co.edu.uptc.sw2.proyectofinalfotos.persistence;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Photographer;
import co.edu.uptc.sw2.proyectofinalfotos.errors.ErrorCompany;
import com.google.gson.Gson;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class PhotographerDAO {

    @PersistenceContext
    private EntityManager entityManager;
    private static final ErrorCompany ERROR_COMPANY = new ErrorCompany(0, "Datos erroneos");
    private static final Gson GSON = new Gson();

    public String getPhotographer(String email) {
        try {
            Query query = entityManager.createNamedQuery("getPhotographer", Photographer.class);
            query.setParameter("email", email);
            return GSON.toJson(query.getSingleResult());
        } catch (Exception e) {
            System.out.println("No hay datos");
        }
        return GSON.toJson(ERROR_COMPANY);
    }

}