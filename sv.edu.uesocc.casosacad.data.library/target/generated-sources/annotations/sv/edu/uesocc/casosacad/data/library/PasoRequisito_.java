package sv.edu.uesocc.casosacad.data.library;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.casosacad.data.library.Paso;
import sv.edu.uesocc.casosacad.data.library.Requisito;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-17T10:42:50")
@StaticMetamodel(PasoRequisito.class)
public class PasoRequisito_ { 

    public static volatile SingularAttribute<PasoRequisito, Integer> idPasoRequisito;
    public static volatile SingularAttribute<PasoRequisito, Integer> indice;
    public static volatile SingularAttribute<PasoRequisito, Paso> idPaso;
    public static volatile SingularAttribute<PasoRequisito, Requisito> idRequisito;

}