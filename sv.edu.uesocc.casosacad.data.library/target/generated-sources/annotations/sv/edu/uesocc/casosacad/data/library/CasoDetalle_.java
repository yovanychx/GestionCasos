package sv.edu.uesocc.casosacad.data.library;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.casosacad.data.library.Caso;
import sv.edu.uesocc.casosacad.data.library.CasoDetalleRequisito;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-06T18:11:25")
@StaticMetamodel(CasoDetalle.class)
public class CasoDetalle_ { 

    public static volatile SingularAttribute<CasoDetalle, Integer> idCasoDetalle;
    public static volatile SingularAttribute<CasoDetalle, Date> fecha;
    public static volatile SingularAttribute<CasoDetalle, String> estado;
    public static volatile SingularAttribute<CasoDetalle, Caso> idCaso;
    public static volatile ListAttribute<CasoDetalle, CasoDetalleRequisito> casoDetalleRequisitoList;
    public static volatile SingularAttribute<CasoDetalle, Integer> idProcesDetalle;

}