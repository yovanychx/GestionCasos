package sv.edu.uesocc.casosacad.data.library;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.casosacad.data.library.CasoDetalle;
import sv.edu.uesocc.casosacad.data.library.DbCdra;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-06T18:11:25")
@StaticMetamodel(CasoDetalleRequisito.class)
public class CasoDetalleRequisito_ { 

    public static volatile SingularAttribute<CasoDetalleRequisito, Integer> idCDR;
    public static volatile SingularAttribute<CasoDetalleRequisito, CasoDetalle> idCasoDetalle;
    public static volatile SingularAttribute<CasoDetalleRequisito, Date> fecha;
    public static volatile SingularAttribute<CasoDetalleRequisito, Integer> idPasoRequisito;
    public static volatile SingularAttribute<CasoDetalleRequisito, String> estadoRequisito;
    public static volatile ListAttribute<CasoDetalleRequisito, DbCdra> dbCdraList;

}