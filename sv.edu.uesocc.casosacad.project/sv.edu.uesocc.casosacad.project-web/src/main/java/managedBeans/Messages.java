/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;


/**
 *
 * @author yovany
 */
public class Messages implements Serializable {
    
    private Severity severity=FacesMessage.SEVERITY_ERROR;
    private String message;
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
    }

    public void MsgCreado() {
        setMessage("Registro guardado con éxito.");
        saveMessage();
    }
    
    public void MsgBorrado() {
        setMessage("Registro eliminado con éxito.");
        saveMessage();
    }
    
    public void MsgModificado() {
        setMessage("Registro modificado con éxito.");
        saveMessage();
    }
    
    public void MsgIncompleto() {
        setMessage("Por favor llene todos los campos.");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severity, message, message));
    }

}
