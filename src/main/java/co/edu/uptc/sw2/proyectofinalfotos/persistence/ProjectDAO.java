package co.edu.uptc.sw2.proyectofinalfotos.persistence;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Proyect;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProjectDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    public Proyect getProject(int idProject) {
        return entityManager.createNamedQuery("getProject", Proyect.class).setParameter("idProject", idProject).getSingleResult();
    }
    
    public void updateProject(Proyect proyect) {
        entityManager.merge(proyect);
    }

}
