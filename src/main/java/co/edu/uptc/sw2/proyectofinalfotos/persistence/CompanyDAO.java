/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectofinalfotos.persistence;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Company;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FREDY
 */
@Stateless
public class CompanyDAO {
 
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

    public void getCompany(String email, String password) {
    }
}
