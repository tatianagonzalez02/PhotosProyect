package co.edu.uptc.sw2.proyectofinalfotos.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("ProyectService")
public class ProyectService {
    
    @POST
    @Path("/sendPhoto")
    public void sendPhoto(File image) throws IOException{
        System.out.println(image);
        BufferedImage image1 = ImageIO.read(image);
        File outputFile = new File("C:/Users/asus/desktop/mifoto.png");
        ImageIO.write(image1, "png", outputFile);
    }
    
}
