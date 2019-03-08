/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectofinalfotos.logic;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Proyect;
import co.edu.uptc.sw2.proyectofinalfotos.persistence.ProjectDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author FREDY
 */
@Stateless
public class ProjectLogic {
    
    @EJB
    private ProjectDAO projectDAO;
 
    public void updateProject(Proyect proyect){
        projectDAO.updateProject(proyect);
    }
}