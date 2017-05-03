package sv.edu.uesocc.casosacad.data.library;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.casosacad.data.library.Paso;
import sv.edu.uesocc.casosacad.data.library.Proceso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-06T18:11:25")
@StaticMetamodel(ProcesoDetalle.class)
public class ProcesoDetalle_ { 

    public static volatile SingularAttribute<ProcesoDetalle, Integer> idProcesoDetalle;
    public static volatile SingularAttribute<ProcesoDetalle, Integer> indice;
    public static volatile SingularAttribute<ProcesoDetalle, Paso> idPaso;
    public static volatile SingularAttribute<ProcesoDetalle, Proceso> idProceso;

}