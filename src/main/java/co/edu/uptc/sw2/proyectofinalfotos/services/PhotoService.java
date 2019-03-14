package co.edu.uptc.sw2.proyectofinalfotos.services;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import co.edu.uptc.sw2.proyectofinalfotos.logic.PhotoLogic;
import co.edu.uptc.sw2.proyectofinalfotos.logic.ProjectLogic;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author FREDY
 */
@Path("PhotoService")
public class PhotoService {
    
    @EJB
    private PhotoLogic photoLogic;
    
    @EJB
    private ProjectLogic projectLogic;
    
    @POST
    @Path("/{idProject}")
    public void addPhoto(@PathParam("idProject") int idProject, Photo photo){
        photoLogic.addPhoto(idProject, photo);
    }
    
    @GET
    @Path("/{idProject}")
    public List<Photo> getPhotos(@PathParam("idProject") int idProject){
        return projectLogic.getProject(idProject).getListPhotos();
    }
}
