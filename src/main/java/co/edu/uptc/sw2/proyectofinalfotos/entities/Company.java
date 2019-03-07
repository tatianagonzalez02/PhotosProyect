package co.edu.uptc.sw2.proyectofinalfotos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Karol Alfonso, fredy gamba, yulina y jhon
 */
@Entity
@NamedQueries({
@NamedQuery(name="company", query="SELECT c FROM Company c WHERE c.emailCompany = :email"),
@NamedQuery(name="company2", query="SELECT c FROM Company c WHERE c.emailCompany = :email AND c.password = :password"),
        @NamedQuery(name="getCompany", query="SELECT c FROM Company c WHERE c.idCompany = :id")
})
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCompany;
    private String nameCompany;
    private String emailCompany;
    private String password;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
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

    @Override
    public String toString() {
        return "Company{" + "idCompany=" + idCompany + ", nameCompany=" + nameCompany + ", emailCompany=" + emailCompany + ", password=" + password + ", listProyects=" + listProyects + '}';
    }
}
