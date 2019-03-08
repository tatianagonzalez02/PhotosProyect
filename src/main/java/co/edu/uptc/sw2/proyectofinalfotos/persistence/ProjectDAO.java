/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectofinalfotos.persistence;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Proyect;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FREDY
 */
@Stateless
public class ProjectDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    public void updateProject(Proyect proyect) {
        entityManager.merge(proyect);
    }
    
}
