package co.edu.uptc.sw2.proyectofinalfotos.logic;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Proyect;
import co.edu.uptc.sw2.proyectofinalfotos.persistence.ProjectDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProjectLogic {
    
    @EJB
    private ProjectDAO projectDAO;
 
    public void updateProject(Proyect proyect){
        projectDAO.updateProject(proyect);
    }

    public Proyect getProject(int idProject) {
        return projectDAO.getProject(idProject);
    }
}