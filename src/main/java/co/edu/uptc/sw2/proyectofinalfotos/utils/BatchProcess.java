package co.edu.uptc.sw2.proyectofinalfotos.utils;

import co.edu.uptc.sw2.proyectofinalfotos.entities.EnumStatus;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Photographer;
import co.edu.uptc.sw2.proyectofinalfotos.logic.PhotoLogic;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class BatchProcess {

    @EJB
    private PhotoLogic photoLogic;

    private static final String PATH = "C:\\Users\\asus\\Downloads\\imgProcess\\";

    @Schedule(minute = "*", hour = "*", second = "0/15", persistent = false)
    public void searchImages() {
        System.out.println(new Date().getSeconds() + " Voy a buscar imagenes sin procesar...");
        List<Photo> photos = photoLogic.getPhotos(EnumStatus.IN_PROCESS);
        for (Photo photo : photos) {
            try {
                System.out.println("Encontre una foto sin procesar, es: " + photo);
                String path = photo.getPath();
                Photographer photographer = photo.getPhotographer();
                ImageManager.copyImage(path, PATH + new File(path).getName(),
                        photographer.getName() + " " + photographer.getLastName(),
                        new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(photo.getDate()));
                photo.setEnumStatus(EnumStatus.AVAILABLE);
                photoLogic.update(photo);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Ya termine de buscar imagenes");
    }
}
