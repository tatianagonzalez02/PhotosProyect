package co.edu.uptc.sw2.proyectofinalfotos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "getPhotographer", query = "SELECT p FROM Photographer p WHERE p.emailP = :email")
public class Photographer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPhtographer;
    private String name;
    private String lastName;
    private String emailP;

    public int getIdPhtographer() {
        return idPhtographer;
    }

    public void setIdPhtographer(int idPhtographer) {
        this.idPhtographer = idPhtographer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

}
