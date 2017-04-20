package sv.edu.uesocc.casosacad.data.library;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.casosacad.data.library.Caso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-18T23:46:55")
@StaticMetamodel(Solicitudes.class)
public class Solicitudes_ { 

    public static volatile SingularAttribute<Solicitudes, Date> fechaRecibida;
    public static volatile SingularAttribute<Solicitudes, String> carnet;
    public static volatile ListAttribute<Solicitudes, Caso> casoList;
    public static volatile SingularAttribute<Solicitudes, Integer> nit;
    public static volatile SingularAttribute<Solicitudes, Integer> usuario;
    public static volatile SingularAttribute<Solicitudes, Integer> idSolicitud;
    public static volatile SingularAttribute<Solicitudes, String> descripcionSolicitud;

}