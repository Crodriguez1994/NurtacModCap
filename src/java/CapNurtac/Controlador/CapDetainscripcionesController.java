package CapNurtac.Controlador;

import CapNurtac.Entidades.CapDetainscripciones;
import CapNurtac.Controlador.util.JsfUtil;
import CapNurtac.Controlador.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("capDetainscripcionesController")
@SessionScoped
public class CapDetainscripcionesController implements Serializable {

    @EJB
    private CapNurtac.Controlador.CapDetainscripcionesFacade ejbFacade;
    private List<CapDetainscripciones> items = null;
    private CapDetainscripciones selected;

    public CapDetainscripcionesController() {
    }

    public CapDetainscripciones getSelected() {
        return selected;
    }

    public void setSelected(CapDetainscripciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCapDetainscripcionesPK().setCabinscripcionid(selected.getCapCabinscripciones().getCabinscripcionid());
    }

    protected void initializeEmbeddableKey() {
        selected.setCapDetainscripcionesPK(new CapNurtac.Entidades.CapDetainscripcionesPK());
    }

    private CapDetainscripcionesFacade getFacade() {
        return ejbFacade;
    }

    public CapDetainscripciones prepareCreate() {
        selected = new CapDetainscripciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CapDetainscripcionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CapDetainscripcionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CapDetainscripcionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CapDetainscripciones> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public CapDetainscripciones getCapDetainscripciones(CapNurtac.Entidades.CapDetainscripcionesPK id) {
        return getFacade().find(id);
    }

    public List<CapDetainscripciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CapDetainscripciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CapDetainscripciones.class)
    public static class CapDetainscripcionesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CapDetainscripcionesController controller = (CapDetainscripcionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "capDetainscripcionesController");
            return controller.getCapDetainscripciones(getKey(value));
        }

        CapNurtac.Entidades.CapDetainscripcionesPK getKey(String value) {
            CapNurtac.Entidades.CapDetainscripcionesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new CapNurtac.Entidades.CapDetainscripcionesPK();
            key.setCabinscripcionid(Integer.parseInt(values[0]));
            key.setDetainsid(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(CapNurtac.Entidades.CapDetainscripcionesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCabinscripcionid());
            sb.append(SEPARATOR);
            sb.append(value.getDetainsid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CapDetainscripciones) {
                CapDetainscripciones o = (CapDetainscripciones) object;
                return getStringKey(o.getCapDetainscripcionesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CapDetainscripciones.class.getName()});
                return null;
            }
        }

    }

}
