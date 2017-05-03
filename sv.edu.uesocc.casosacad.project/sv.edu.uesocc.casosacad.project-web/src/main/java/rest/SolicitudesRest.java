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
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.casosacad.data.library.Solicitudes;
import sv.edu.uesocc.casosacad.pojos.SolicitudesFacadeLocal;

/**
 *
 * @author yovany
 */
@Path("solicitudes")
public class SolicitudesRest implements Serializable{
    @EJB
    private SolicitudesFacadeLocal ejbSolicitud;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<Solicitudes> findAll() {
        List<Solicitudes> salida = null;

        try {
            if (ejbSolicitud != null) {
                salida = ejbSolicitud.findAll();
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
            if (ejbSolicitud != null) {
                return ejbSolicitud.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }
    
    @GET
    @Path("findbyid/{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public Solicitudes findById( @PathParam("id") Integer id)
    {
        try {
            if (ejbSolicitud != null) {
                return ejbSolicitud.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new Solicitudes();
    }  
}
