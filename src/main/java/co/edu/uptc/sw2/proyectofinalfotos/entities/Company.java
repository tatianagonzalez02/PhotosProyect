package co.edu.uptc.sw2.proyectofinalfotos.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Karol Alfonso
 */
@Entity
public class Company {

    @Id
    private int idCompany;
    private String nameCompany;
    private String emailCompany;
    private String password;
    private List<Proyect> listProyects;

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getEmailCompany() {
        return emailCompany;
    }

    public void setEmailCompany(String emailCompany) {
        this.emailCompany = emailCompany;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Proyect> getListProyects() {
        return listProyects;
    }

    public void setListProyects(List<Proyect> listProyects) {
        this.listProyects = listProyects;
    }

}
