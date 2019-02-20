/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectofinalfotos.logic;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Company;
import co.edu.uptc.sw2.proyectofinalfotos.persistence.CompanyDAO;
import co.edu.uptc.sw2.proyectofinalfotos.utils.Strings;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author FREDY
 */
@Stateless
public class CompanyLogic {
    
    @EJB
    private CompanyDAO companyDAO;
    
    public boolean addCompany(Company company){
        if (companyDAO.getCompany(company.getEmailCompany()) == null) {
            company.setPassword(Strings.getHash(company.getPassword(), "SHA1"));
            companyDAO.addCompany(company);
            return true;
        }else{
            return false;
        }
    }
    
    public String verifyCompany(String email, String password){
        return companyDAO.getCompany(email, password);
    }
    
}