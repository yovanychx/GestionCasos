/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static java.util.Locale.filter;
import static java.util.Locale.filter;
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
import sv.edu.uesocc.casosacad.data.library.Solicitudes;
import sv.edu.uesocc.casosacad.pojos.SolicitudesFacadeLocal;

/**
 *
 * @author yovany
 */
@Named(value = "mbSolicitudes")
@ViewScoped
public class mbSolicitudes implements Serializable {

    @EJB
    private SolicitudesFacadeLocal fl;
    private LazyDataModel<Solicitudes> ldm;
    private Solicitudes c = new Solicitudes();
    private Solicitudes selectedSolicitud;
    private boolean showDetail = true;
    private boolean btnAdd = true;
    private boolean btnEdit = false;
    private Messages msg = new Messages();

    @PostConstruct
    private void init() {
        selectedSolicitud = new Solicitudes();
        try {
            this.setLdm(new LazyDataModel<Solicitudes>() {
                @Override
                public Object getRowKey(Solicitudes object) {
                    if (object != null) {
                        return object.getIdSolicitud();
                    }
                    return null;
                }

                @Override
                public Solicitudes getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Solicitudes thi : (List<Solicitudes>) getWrappedData()) {
                                if (thi.getIdSolicitud().compareTo(buscado) == 0) {
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
                public List<Solicitudes> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Solicitudes> salida = new ArrayList();

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
                        if (!filters.isEmpty() && (filters.containsKey("idSolicitud") || filters.containsKey("carnet") || filters.containsKey("nit") || filters.containsKey("usuario") || filters.containsKey("descripcionSolicitud") || filters.containsKey("fechaRecibida"))) {

                            if (filters.containsKey("idSolicitud")) {
                                salida = fl.findBy("idSolicitud", filters.get("idSolicitud").toString());
                                if (ldm != null) {
                                    ldm.setRowCount(salida.size());
                                }
                            } else if (filters.containsKey("carnet")) {
                                salida = fl.findBy("carnet", filters.get("carnet").toString());
                                if (ldm != null) {
                                    ldm.setRowCount(salida.size());
                                }
                            } else if (filters.containsKey("descripcionSolicitud")) {
                                salida = fl.findBy("descripcionSolicitud", filters.get("descripcionSolicitud").toString());
                                if (ldm != null) {
                                    ldm.setRowCount(salida.size());
                                }
                            } else if (filters.containsKey("nit")) {

                                salida = fl.findBy("nit", filters.get("nit").toString());

                                if (ldm != null) {
                                    ldm.setRowCount(salida.size());
                                }
                            } else if (filters.containsKey("usuario")) {

                                salida = fl.findBy("usuario", filters.get("usuario").toString());

                                if (ldm != null) {
                                    ldm.setRowCount(salida.size());
                                }
                            } else if (filters.containsKey("fechaRecibida")) {

                                salida = fl.findBy("fechaRecibida", filters.get("fechaRecibida").toString());

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

    public Solicitudes getC() {
        return c;
    }

    public void setC(Solicitudes c) {
        this.c = c;
    }

    public SolicitudesFacadeLocal getFl() {
        return fl;
    }

    public void setFl(SolicitudesFacadeLocal fl) {
        this.fl = fl;
    }

    public List<Solicitudes> findAll() {
        return getFl().findAll();
    }

    public void create() {
        if (this.getSelectedSolicitudes().getCarnet().isEmpty() != true && this.getSelectedSolicitudes().getDescripcionSolicitud().isEmpty() != true) {
            try {
                java.util.Date fecha = new java.util.Date();
                getSelectedSolicitudes().setFechaRecibida(fecha);
                this.getFl().create(this.getSelectedSolicitudes());
                selectedSolicitud = new Solicitudes();
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

    public void remove() {
        try {
            this.getFl().remove(this.getSelectedSolicitudes());
            selectedSolicitud = new Solicitudes();
            btnAdd = true;
            btnEdit = false;
            msg.MsgBorrado();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void edit(Solicitudes t) {
        this.setC(t);
    }

    public void edit() {

        try {
            this.getFl().edit(this.getSelectedSolicitudes());
            selectedSolicitud = new Solicitudes();
            btnAdd = true;
            btnEdit = false;
            msg.MsgModificado();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void empty() {
        this.setC(new Solicitudes());
    }

    public Solicitudes getSelectedSolicitudes() {
        return selectedSolicitud;
    }

    public void setSelectedSolicitudes(Solicitudes selecSolicitud) {
        this.selectedSolicitud = selecSolicitud;
    }

    public LazyDataModel getLdm() {
        return ldm;
    }

    public void setLdm(LazyDataModel ldm) {
        this.ldm = ldm;
    }

    public void changeSelected(SelectEvent se) {
        if (se.getObject() != null) {
            try {
                this.selectedSolicitud = (Solicitudes) se.getObject();
                this.setShowDetail(true);
                this.setBtnAdd(false);
                this.setBtnEdit(true);

            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }

    public void nuevo() {

        this.selectedSolicitud = new Solicitudes();
        this.setBtnAdd(true);
        this.setBtnEdit(false);
        this.setShowDetail(true);
    }

    public boolean isShowDetail() {
        return showDetail;
    }

    public void setShowDetail(boolean showDetail) {
        this.showDetail = showDetail;
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
}