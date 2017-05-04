/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.casosacad.data.library.Paso;
import sv.edu.uesocc.casosacad.data.library.PasoRequisito;
import sv.edu.uesocc.casosacad.pojos.PasoFacadeLocal;
import sv.edu.uesocc.casosacad.pojos.PasoRequisitoFacadeLocal;

/**
 *
 * @author yovany
 */
@Path("pasorequisito")
public class PasoRequisitoRest implements Serializable{
    @EJB
    private PasoRequisitoFacadeLocal ejbPasoRequisito;
    
    @EJB
    private PasoFacadeLocal ejbPaso;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<PasoRequisito> findAll() {
        List<PasoRequisito> salida = null;

        try {
            if (ejbPasoRequisito != null) {
                salida = ejbPasoRequisito.findAll();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (salida == null) {
                salida = new ArrayList<>();
            }
        }
        System.out.println(""+salida);
        return salida;
    }
    
    @Path("count")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {

        try {
            if (ejbPasoRequisito != null) {
                return ejbPasoRequisito.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }
    
     
    @GET
    @Path("findbyid/{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public PasoRequisito findById( @PathParam("id") Integer id)
    {
        try {
            if (ejbPasoRequisito != null) {
                return ejbPasoRequisito.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new PasoRequisito();
    }
    
    
    @GET
    @Path("findidpaso/")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<PasoRequisito> findPaso( 
            @QueryParam("idpaso") int id)
    {
        List salida = null;
        try {
            if (ejbPasoRequisito != null) {
                return ejbPasoRequisito.findByJoined("idPaso", (Paso) ejbPaso.find(id));
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
}
