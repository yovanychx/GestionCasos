package rest;

import java.util.Set;
import javax.ws.rs.core.Application;


/**
 *
 * @author yovany
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(rest.CasoDetalleRequisitoAtestadoRest.class);
        resources.add(rest.CasoDetalleRequisitoRest.class);
        resources.add(rest.CasoDetalleRest.class);
        resources.add(rest.CasoRest.class);
        resources.add(rest.Cros.class);
        resources.add(rest.PasoRequisitoRest.class);
        resources.add(rest.PasoRest.class);
        resources.add(rest.ProcesoDetalleRest.class);
        resources.add(rest.ProcesoRest.class);
        resources.add(rest.RequisitoRest.class);
        resources.add(rest.SolicitudesRest.class);
        resources.add(rest.TipoPasoRest.class);
        resources.add(rest.TipoRequisitoRest.class);
        return resources;
    }
    
    
     private void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(rest.CasoDetalleRequisitoAtestadoRest.class);
        resources.add(rest.CasoDetalleRequisitoRest.class);
        resources.add(rest.CasoDetalleRest.class);
        resources.add(rest.CasoRest.class);
        resources.add(rest.Cros.class);
        resources.add(rest.PasoRequisitoRest.class);
        resources.add(rest.PasoRest.class);
        resources.add(rest.ProcesoDetalleRest.class);
        resources.add(rest.ProcesoRest.class);
        resources.add(rest.RequisitoRest.class);
        resources.add(rest.SolicitudesRest.class);
        resources.add(rest.TipoPasoRest.class);
        resources.add(rest.TipoRequisitoRest.class);
    }
    
}
