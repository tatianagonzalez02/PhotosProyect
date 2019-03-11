/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uptc.sw2.proyectofinalfotos.utils;

import co.edu.uptc.sw2.proyectofinalfotos.entities.EnumStatus;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import co.edu.uptc.sw2.proyectofinalfotos.logic.PhotoLogic;
import java.io.File;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author FREDY
 */
@Stateless
public class BatchProcess {
 
    @EJB
    private PhotoLogic photoLogic;
    
    private static final String PATH = "C:\\Users\\FREDY\\Downloads\\imgProcess\\";
    
    @Schedule(minute = "*", hour = "*", second = "0/10", persistent = false)
    public void searchImages(){
        System.out.println("Voy a buscar imagenes sin procesar...");
        List<Photo> photos = photoLogic.getPhotos();
        for (Photo photo : photos) {
            if (photo.getEnumStatus() == EnumStatus.IN_PROCESS) {
                String path = photo.getPath();
                System.out.println("Encontre una foto sin procesar, es: " + photo);
                ImageManager.copyImage(path, PATH + new File(path).getName());
                photo.setEnumStatus(EnumStatus.AVAILABLE);
                photoLogic.update(photo);
            }
        }
        System.out.println("Ya termine de buscar imagenes");
    }
}
