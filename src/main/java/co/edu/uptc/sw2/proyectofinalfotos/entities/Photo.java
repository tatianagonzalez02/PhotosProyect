package co.edu.uptc.sw2.proyectofinalfotos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPhoto;
    private Photographer photographer;
    private double requestValue;
    private EnumStatus enumStatus;
    private String path;
//    @Temporal(TemporalType.DATE)
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Photo{" + "idPhoto=" + idPhoto + ", photographer=" + photographer + ", requestValue=" + requestValue + ", enumStatus=" + enumStatus + ", path=" + path + ", date=" + date + '}';
    }
    
}
