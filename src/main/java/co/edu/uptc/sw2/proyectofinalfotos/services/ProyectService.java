package co.edu.uptc.sw2.proyectofinalfotos.services;

import co.edu.uptc.sw2.proyectofinalfotos.entities.EnumStatus;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import co.edu.uptc.sw2.proyectofinalfotos.entities.Proyect;
import co.edu.uptc.sw2.proyectofinalfotos.logic.ProjectLogic;
import co.edu.uptc.sw2.proyectofinalfotos.utils.FilesManager;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("ProyectService")
public class ProyectService {
    
    @EJB
    private ProjectLogic projectLogic;
    
    @POST
    @Path("/sendPhoto")
    public String sendPhoto(File image) throws IOException{
        return FilesManager.saveImage(image);
    }
    
    @PUT
    @Path("/update")
    public void updateProject(Proyect proyect){
        List<Photo> photos = proyect.getListPhotos();
        for (Photo photo : photos) {
            photo.setEnumStatus(EnumStatus.IN_PROCESS);
        }
        projectLogic.updateProject(proyect);
    }
    
}
