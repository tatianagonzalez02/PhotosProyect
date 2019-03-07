package co.edu.uptc.sw2.proyectofinalfotos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;

/**
 * Proyecto creado por el administrador de la compañia
 *
 * @author Karol Alfonso
 */
@Entity
@NamedQueries({
})
public class Proyect implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProyect;
    private String name;
    private String description;
    private double valuePay;
    private List<Photo> listPhotos;

    public int getId() {
        return idProyect;
    }

    public void setId(int idProyect) {
        this.idProyect = idProyect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValuePay() {
        return valuePay;
    }

    public void setValuePay(double valuePay) {
        this.valuePay = valuePay;
    }

    public List<Photo> getListPhotos() {
        return listPhotos;
    }

    public void setListPhotos(List<Photo> listPhotos) {
        this.listPhotos = listPhotos;
    }

    @Override
    public String toString() {
        return "Proyect{" + "idProyect=" + idProyect + ", name=" + name + ", description=" + description + ", valuePay=" + valuePay + ", listPhotos=" + listPhotos + '}';
    }
    
}
