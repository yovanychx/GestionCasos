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
import sv.edu.uesocc.casosacad.data.library.CasoDetalle;
import sv.edu.uesocc.casosacad.pojos.CasoDetalleFacadeLocal;

/**
 *
 * @author yovany
 */
@Path("casodetalle")
public class CasoDetalleRest implements Serializable {

    @EJB
    private CasoDetalleFacadeLocal ejbCasoDetalle;

    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<CasoDetalle> findAll() {
        List<CasoDetalle> salida = null;

        try {
            if (ejbCasoDetalle != null) {
                salida = ejbCasoDetalle.findAll();
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
            if (ejbCasoDetalle != null) {
                return ejbCasoDetalle.count();
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    @GET
    @Path("findbyid/{id}")
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public CasoDetalle findById(@PathParam("id") Integer id) {
        try {
            if (ejbCasoDetalle != null) {
                return ejbCasoDetalle.find(id);
            }

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return new CasoDetalle();

    }
}
