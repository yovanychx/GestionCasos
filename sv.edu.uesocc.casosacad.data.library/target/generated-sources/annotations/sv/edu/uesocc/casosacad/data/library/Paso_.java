package sv.edu.uesocc.casosacad.data.library;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.casosacad.data.library.PasoRequisito;
import sv.edu.uesocc.casosacad.data.library.ProcesoDetalle;
import sv.edu.uesocc.casosacad.data.library.TipoPaso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-21T10:59:34")
@StaticMetamodel(Paso.class)
public class Paso_ { 

    public static volatile SingularAttribute<Paso, String> descripcion;
    public static volatile SingularAttribute<Paso, TipoPaso> idTipoPaso;
    public static volatile SingularAttribute<Paso, String> tiempo;
    public static volatile ListAttribute<Paso, PasoRequisito> pasoRequisitoList;
    public static volatile SingularAttribute<Paso, Integer> idPaso;
    public static volatile ListAttribute<Paso, ProcesoDetalle> procesoDetalleList;
    public static volatile SingularAttribute<Paso, String> nombre;

}