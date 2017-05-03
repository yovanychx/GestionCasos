/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.casosacad.data.library.Proceso;
import sv.edu.uesocc.casosacad.pojos.ProcesoFacadeLocal;

/**
 *
 * @author user
 */
@Named(value = "mbProceso")
@ViewScoped
public class mbProceso implements Serializable {

    @EJB
    private ProcesoFacadeLocal fl;

    public ProcesoFacadeLocal getFl() {
        return fl;
    }

    public void setFl(ProcesoFacadeLocal fl) {
        this.fl = fl;
    }
    private LazyDataModel<Proceso> ldm;
    private Proceso c = new Proceso();

    public Proceso getC() {
        return c;
    }

    public void setC(Proceso c) {
        this.c = c;
    }
    private Proceso selectedProceso;
    private boolean showDetail = true;
    private boolean btnAdd = true;
    private boolean btnEdit = false;
    private Messages msg = new Messages();

    @PostConstruct
     private void init() {
        selectedProceso = new Proceso();
        try {
            this.setLdm(new LazyDataModel<Proceso>() {
                @Override
                public Object getRowKey(Proceso object) {
                    if (object != null) {
                        return object.getIdProceso();
                    }
                    return null;
                }

                @Override
                public Proceso getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Proceso thi : (List<Proceso>) getWrappedData()) {
                                if (thi.getIdProceso().compareTo(buscado) == 0) {
                                    return thi;
                                }
                            }
                        } catch (Exception e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                    }
                    return null;
                }

                @Override
                public List<Proceso> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Proceso> salida = new ArrayList();
                    if (filters == null || filters.isEmpty()) {
                        try {
                            if (fl != null) {
                                this.setRowCount(fl.count());
                                salida = fl.findRange(first, pageSize);
                            }

                        } catch (Exception e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                        return salida;
                    }
                    salida = null;
                    try {
                        if (!filters.isEmpty() && (filters.containsKey("idProceso") || filters.containsKey("nombre") || filters.containsKey("descripcion"))) {

                            if (filters.containsKey("idProceso")) {
                                salida = fl.findBy("idProceso", filters.get("idProceso").toString());
                                if (ldm != null) {
                                    ldm.setRowCount(salida.size());
                                }
                            } else if (filters.containsKey("nombre")) {
                                salida = fl.findBy("nombre", filters.get("nombre").toString());
                                if (ldm != null) {
                                    ldm.setRowCount(salida.size());
                                }
                            } else if (filters.containsKey("descripcion")) {
                                salida = fl.findBy("descripcion", filters.get("descripcion").toString());
                                if (ldm != null) {
                                    ldm.setRowCount(salida.size());
                                }
                            }    
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    } finally {
                        if (salida == null) {
                            salida = new ArrayList();
                        }
                    }
                    return salida;
                }
            });

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public LazyDataModel getLdm() {
        return ldm;
    }

    public void setLdm(LazyDataModel ldm) {
        this.ldm = ldm;
    }

    public Proceso getSelectedProceso() {
        return selectedProceso;
    }

    public void setSelectedProceso(Proceso selectedProceso) {
        this.selectedProceso = selectedProceso;
    }
    public boolean isBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(boolean btnAdd) {
        this.btnAdd = btnAdd;
    }

    public boolean isBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(boolean btnEdit) {
        this.btnEdit = btnEdit;
    }

    public boolean isShowDetail() {
        return showDetail;
    }

    public void setShowDetail(boolean showDetail) {
        this.showDetail = showDetail;
    }
    public void nuevo() {

        this.selectedProceso = new Proceso();
        this.setBtnAdd(true);
        this.setBtnEdit(false);
        this.setShowDetail(true);
    }
    public void create() {
        if (this.getSelectedProceso().getNombre().isEmpty() != true && this.getSelectedProceso().getDescripcion().isEmpty() != true) {
            try {
                this.getFl().create(this.getSelectedProceso());
                selectedProceso = new Proceso();
                btnAdd = true;
                btnEdit = false;
                msg.MsgCreado();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        } else {
            msg.MsgIncompleto();
        }

    }
    public List<Proceso> findAll() {
        return getFl().findAll();
    }
    
    public void remove() {
        try {
            this.getFl().remove(this.getSelectedProceso());
            selectedProceso = new Proceso();
            btnAdd = true;
            btnEdit = false;
            msg.MsgBorrado();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    public void edit(Proceso t) {
        this.setC(t);
    }

    public void edit() {

        try {
            this.getFl().edit(this.getSelectedProceso());
            selectedProceso = new Proceso();
            btnAdd = true;
            btnEdit = false;
            msg.MsgModificado();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    public void empty() {
        this.setC(new Proceso());
    }
     public void changeSelected(SelectEvent se) {
        if (se.getObject() != null) {
            try {
                this.selectedProceso = (Proceso) se.getObject();
                this.setShowDetail(true);
                this.setBtnAdd(false);
                this.setBtnEdit(true);

            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }
    
}
