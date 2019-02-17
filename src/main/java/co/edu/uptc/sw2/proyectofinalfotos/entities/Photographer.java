package co.edu.uptc.sw2.proyectofinalfotos.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Karol Alfonso
 */
@Entity
public class Photographer {

    @Id
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