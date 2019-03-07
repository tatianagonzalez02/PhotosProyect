package co.edu.uptc.sw2.proyectofinalfotos.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Karol Alfonso
 */
@Entity
public class Photo {

    @Id
    private int idPhoto;
    private Photographer photographer;
    private double requestValue;
    private EnumStatus enumStatus;
    private String path;

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer = photographer;
    }

    public double getRequestValue() {
        return requestValue;
    }

    public void setRequestValue(double requestValue) {
        this.requestValue = requestValue;
    }

    public EnumStatus getEnumStatus() {
        return enumStatus;
    }

    public void setEnumStatus(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
