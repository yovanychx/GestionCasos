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
import sv.edu.uesocc.casosacad.data.library.Proceso;
import sv.edu.uesocc.casosacad.data.library.ProcesoDetalle;
import sv.edu.uesocc.casosacad.pojos.ProcesoDetalleFacadeLocal;
import sv.edu.uesocc.casosacad.pojos.ProcesoFacadeLocal;

/**
 *
 * @author yovany
 */
@Path("procesodetalle")
public class ProcesoDetalleRest implements Serializable {

    @EJB
    private ProcesoDetalleFacadeLocal ejbProsDet;
    @EJB
    private ProcesoFacadeLocal ejbProceso;

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<ProcesoDetalle> findAll() {
        List<ProcesoDetalle> salida = null;

        try {
            if (ejbProsDet != null) {
                salida = ejbProsDet.findAll();
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (salida == null) {
                salida = new ArrayList<>();
            }
        }
        System.out.println("" + salida);
        return salida;
    }

    @Path("count")
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public Integer count() {

        try {
            if (ejbProsDet != null) {
                return ejbProsDet.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    @GET
    @Path("findbyid/{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public ProcesoDetalle findById(@PathParam("id") Integer id) {
        try {
            if (ejbProsDet != null) {
                return ejbProsDet.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new ProcesoDetalle();

    }
    
    @GET
    @Path("findidproceso/")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<ProcesoDetalle> findProceso( 
            @QueryParam("idproceso") int id)
    {
        List salida = null;
        try {
            if (ejbProsDet != null) {
                return ejbProsDet.findByJoined("idProceso", (Proceso) ejbProceso.find(id));
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return salida;
    }
}
