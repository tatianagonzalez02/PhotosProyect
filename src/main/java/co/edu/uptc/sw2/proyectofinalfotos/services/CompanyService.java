/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectofinalfotos.services;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Company;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author FREDY
 */
@Path("CompanyService")
public class CompanyService {
    
    @POST
    public void registerCompany(Company company){
        System.out.println(company);
    }
}
