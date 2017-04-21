package sv.edu.uesocc.casosacad.data.library;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.casosacad.data.library.Caso;
import sv.edu.uesocc.casosacad.data.library.ProcesoDetalle;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-21T10:59:34")
@StaticMetamodel(Proceso.class)
public class Proceso_ { 

    public static volatile SingularAttribute<Proceso, String> descripcion;
    public static volatile ListAttribute<Proceso, Caso> casoList;
    public static volatile ListAttribute<Proceso, ProcesoDetalle> procesoDetalleList;
    public static volatile SingularAttribute<Proceso, Integer> idProceso;
    public static volatile SingularAttribute<Proceso, String> nombre;

}