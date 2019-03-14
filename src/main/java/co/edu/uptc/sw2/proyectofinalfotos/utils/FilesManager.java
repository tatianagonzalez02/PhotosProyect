package co.edu.uptc.sw2.proyectofinalfotos.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FilesManager {
    
    public static final String PATH = "C:/Users/asus/Downloads/img/";
 
    public static String saveImage(File image) throws IOException{
        String[] files = new File(PATH).list();
        int lastID = 1;
        if (files.length > 0) {
            String file = files[files.length - 1];
            lastID = Integer.parseInt(file.substring(0, file.length()  - 4)) + 1;
        }
        BufferedImage image1 = ImageIO.read(image);
        File outputFile = new File(PATH + lastID + ".png");
        ImageIO.write(image1, "png", outputFile);
        return outputFile.getPath();
    }
    
}