package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.RequestScoped;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.DualListModel;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.casosacad.data.library.Paso;
import sv.edu.uesocc.casosacad.data.library.PasoRequisito;
import sv.edu.uesocc.casosacad.data.library.Requisito;
import sv.edu.uesocc.casosacad.pojos.PasoFacadeLocal;
import sv.edu.uesocc.casosacad.pojos.RequisitoFacadeLocal;

/**
 *
 * @author wxlter97
 */
@Named(value = "mbPickList")
@RequestScoped
public class mbPickList implements Serializable{
 
    private PasoFacadeLocal paso;
    private List<Requisito> source = new ArrayList<>();
    private List<Requisito> target = new ArrayList<>();
    private DualListModel<Requisito> lista;

    private mbPasoRequisito pr;
    @EJB
    private RequisitoFacadeLocal req;
    
    @PostConstruct
    private void init() {

        if(pr.getSelectedPaso()!=null){
        source=cargarSource(paso.find(1));
        target=cargarTarget(paso.find(1));
        lista = new DualListModel<>(source, target);
        } else {
        source=req.findAll();
        lista = new DualListModel<>(source, target);
            
        }

    }

    public List<Requisito> getSource() {
        return source;
    }

    public void setSource(List<Requisito> source) {
        this.source = source;
    }

    public List<Requisito> getTarget() {
        return target;
    }

    public void setTarget(List<Requisito> target) {
        this.target = target;
    }

    public DualListModel<Requisito> getLista() {
        return lista;
    }

    public void setLista(DualListModel<Requisito> lista) {
        this.lista = lista;
    }

    public RequisitoFacadeLocal getReq() {
        return req;
    }

    public void setReq(RequisitoFacadeLocal req) {
        this.req = req;
    }
    
     public List<Requisito> cargarSource(Paso selected){
    List<Requisito> fuente = null;
    fuente=req.findAll();
    for(int i=0; i<selected.getPasoRequisitoList().size();i++){
    fuente.remove(selected.getPasoRequisitoList().get(i).getIdRequisito());    
   
    }
     return fuente;
}
    
    public List<Requisito> cargarTarget(Paso selected){
    List<Requisito> destino = null;
    for(int i=0; i<selected.getPasoRequisitoList().size();i++){
        destino.add(selected.getPasoRequisitoList().get(i).getIdRequisito());  
    
    }
    return destino;
}
    public mbPickList() {
    }
    
}
