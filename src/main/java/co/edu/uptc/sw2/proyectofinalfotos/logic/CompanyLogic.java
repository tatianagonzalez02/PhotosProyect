package co.edu.uptc.sw2.proyectofinalfotos.logic;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Company;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Proyect;
import co.edu.uptc.sw2.proyectofinalfotos.persistence.CompanyDAO;
import co.edu.uptc.sw2.proyectofinalfotos.utils.Strings;
import java.util.Comparator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
        return companyDAO.getCompany(email, Strings.getHash(password, "SHA1"));
    }

    public Company getCompany(int idCompany) {
        Company company = companyDAO.getCompany(idCompany);
        List<Proyect> proyects = company.getListProyects();
        for (Proyect proyect : proyects) {
            proyect.getListPhotos().sort(new Comparator<Photo>() {
                @Override
                public int compare(Photo photo1, Photo photo2) {
                    return photo2.getDate().compareTo(photo1.getDate());
                };
            });
        }
        return company;
    }
    
    public List<Company> getCompanies() {
        return companyDAO.getCompanies();
    }

    public List<Company> getProyects(int id) {
        return companyDAO.getProyects(id);
    }
}