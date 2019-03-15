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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.mail.MessagingException;

@Stateless
public class BatchProcess {

    @EJB
    private PhotoLogic photoLogic;

    private static final String PATH = "C:\\Users\\FREDY\\Documents\\UPTC\\Software II\\PhotosProyect\\src\\main\\webapp\\cacheImages\\";
    private static final String PATH_RELATIVE = "cacheImages\\";

    @Schedule(hour = "*", minute = "*", second = "0/20", persistent = false)
    public void searchImages() {
        System.out.println(new Date().getSeconds() + " Voy a buscar imagenes sin procesar...");
        List<Photo> photos = photoLogic.getPhotos(EnumStatus.IN_PROCESS);
        for (Photo photo : photos) {
            try {
                System.out.println("Encontre una foto sin procesar, es: " + photo);
                String path = photo.getPath();
                Photographer photographer = photo.getPhotographer();
                String fileName = new File(path).getName();
                ImageManager.copyImage(path, PATH + fileName,
                        photographer.getName() + " " + photographer.getLastName(),
                        new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(photo.getDate()));
                photo.setEnumStatus(EnumStatus.AVAILABLE);
                photo.setPath(PATH_RELATIVE + fileName);
                photoLogic.update(photo);
                MailsManager.sendMail(GlobalConstant.MAILS_USER, GlobalConstant.MAILS_PASSWORD, 
                        photographer.getEmailP(), GlobalConstant.MAILS_SUBJECT, GlobalConstant.MAILS_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (MessagingException ex) {
                ex.printStackTrace();
                System.out.println("Error al enviar el email.");
            }
        }
        System.out.println("Ya termine de buscar imagenes");
    }
}
