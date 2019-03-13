package co.edu.uptc.sw2.proyectofinalfotos.services;

import co.edu.uptc.sw2.proyectofinalfotos.entities.Photo;
import co.edu.uptc.sw2.proyectofinalfotos.logic.PhotoLogic;
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
    
    @POST
    @Path("/{idProject}")
    public void addPhoto(@PathParam("idProject") int idProject, Photo photo){
        photoLogic.addPhoto(idProject, photo);
    }
    
    @GET
    @Path("/{idProyect})")
    public boolean getPhotos(@PathParam("idProyect") int idProyect){
        System.out.println("Buscar fotos del proyecto: " + idProyect);
        return true;
    }
}
