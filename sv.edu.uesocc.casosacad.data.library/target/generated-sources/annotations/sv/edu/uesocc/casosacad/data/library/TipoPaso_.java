package sv.edu.uesocc.casosacad.data.library;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.casosacad.data.library.Paso;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-21T10:59:34")
@StaticMetamodel(TipoPaso.class)
public class TipoPaso_ { 

    public static volatile SingularAttribute<TipoPaso, Integer> idTipoPaso;
    public static volatile SingularAttribute<TipoPaso, String> descripcion;
    public static volatile ListAttribute<TipoPaso, Paso> pasoList;
    public static volatile SingularAttribute<TipoPaso, String> nombre;
    public static volatile SingularAttribute<TipoPaso, Boolean> activo;

}