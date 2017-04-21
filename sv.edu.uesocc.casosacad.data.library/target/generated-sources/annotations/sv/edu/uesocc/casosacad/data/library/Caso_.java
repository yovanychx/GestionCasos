package sv.edu.uesocc.casosacad.data.library;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.casosacad.data.library.CasoDetalle;
import sv.edu.uesocc.casosacad.data.library.Proceso;
import sv.edu.uesocc.casosacad.data.library.Solicitudes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-21T10:59:34")
@StaticMetamodel(Caso.class)
public class Caso_ { 

    public static volatile SingularAttribute<Caso, Integer> idCaso;
    public static volatile ListAttribute<Caso, CasoDetalle> casoDetalleList;
    public static volatile SingularAttribute<Caso, Solicitudes> idSolicitud;
    public static volatile SingularAttribute<Caso, Proceso> idProceso;

}