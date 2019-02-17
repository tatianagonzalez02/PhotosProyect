package co.edu.uptc.sw2.proyectofinalfotos.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Proyecto creado por el administrador de la compañia
 *
 * @author Karol Alfonso
 */
@Entity
public class Proyect {

    @Id
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

}
