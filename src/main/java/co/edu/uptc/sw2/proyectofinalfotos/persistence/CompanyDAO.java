package co.edu.uptc.sw2.proyectofinalfotos.persistence;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Company;
import com.google.gson.Gson;
import errors.ErrorCompany;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CompanyDAO {
 
    private static final ErrorCompany ERROR_COMPANY = new ErrorCompany(0, "Datos erroneos");
    private static final Gson GSON = new Gson();
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void addCompany(Company company){
        entityManager.persist(company);
    }
    
    public Company getCompany(String email){
        try {
            return entityManager.createNamedQuery("company", Company.class).setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public String getCompany(String email, String password) {
        try {
            Query query = entityManager.createNamedQuery("company2", Company.class);
            System.out.println("Email -> " + email + " Password -> " + password);
            query.setParameter("email", email);
            query.setParameter("password", password);
            return GSON.toJson(query.getSingleResult());
        } catch (Exception e) {
            System.out.println("No hay datos");
        }
        return GSON.toJson(ERROR_COMPANY);
    }

    public List<Company> getCompanies() {
        return entityManager.createQuery("SELECT c FROM Company c").getResultList();
    }

    public List<Company> getProyects(int id) {
//        return entityManager.createNamedQuery("getProyects", Proyect.class).setParameter("id", id).getSingleResult();
        return null;
    }

    public Company getCompany(int idCompany) {
        return entityManager.createNamedQuery("getCompany", Company.class).setParameter("id", idCompany).getSingleResult();
    }
}