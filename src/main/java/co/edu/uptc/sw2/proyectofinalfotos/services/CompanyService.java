package co.edu.uptc.sw2.proyectofinalfotos.services;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Company;
import co.edu.uptc.sw2.proyectofinalfotos.logic.CompanyLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("CompanyService")
public class CompanyService {
    
    @EJB
    private CompanyLogic companyLogic;
    
    @POST
    @Path("/login")
    public String login(Company company){
        return companyLogic.verifyCompany(company.getEmailCompany(), company.getPassword());
    }
    
    @POST
    @Path("/register")
    public boolean registerCompany(Company company){
        return companyLogic.addCompany(company);
    }
    
    @GET
    @Path("/{idCompany}")
    public Company getCompany(@PathParam("idCompany") int idCompany){
        return companyLogic.getCompany(idCompany);
    }
    
    @GET
    @Path("/companies")
    public List<Company> getCompanies(){
        return companyLogic.getCompanies();
    }
    
}
