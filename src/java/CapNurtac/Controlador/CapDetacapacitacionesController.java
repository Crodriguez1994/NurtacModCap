package CapNurtac.Controlador;

import CapNurtac.Entidades.CapDetacapacitaciones;
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

@Named("capDetacapacitacionesController")
@SessionScoped
public class CapDetacapacitacionesController implements Serializable {

    @EJB
    private CapNurtac.Controlador.CapDetacapacitacionesFacade ejbFacade;
    private List<CapDetacapacitaciones> items = null;
    private CapDetacapacitaciones selected;

    public CapDetacapacitacionesController() {
    }

    public CapDetacapacitaciones getSelected() {
        return selected;
    }

    public void setSelected(CapDetacapacitaciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCapDetacapacitacionesPK().setCabcapid(selected.getCapCabcapacitaciones().getCabcapid());
    }

    protected void initializeEmbeddableKey() {
        selected.setCapDetacapacitacionesPK(new CapNurtac.Entidades.CapDetacapacitacionesPK());
    }

    private CapDetacapacitacionesFacade getFacade() {
        return ejbFacade;
    }

    public CapDetacapacitaciones prepareCreate() {
        selected = new CapDetacapacitaciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CapDetacapacitacionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CapDetacapacitacionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CapDetacapacitacionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CapDetacapacitaciones> getItems() {
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

    public CapDetacapacitaciones getCapDetacapacitaciones(CapNurtac.Entidades.CapDetacapacitacionesPK id) {
        return getFacade().find(id);
    }

    public List<CapDetacapacitaciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CapDetacapacitaciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CapDetacapacitaciones.class)
    public static class CapDetacapacitacionesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CapDetacapacitacionesController controller = (CapDetacapacitacionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "capDetacapacitacionesController");
            return controller.getCapDetacapacitaciones(getKey(value));
        }

        CapNurtac.Entidades.CapDetacapacitacionesPK getKey(String value) {
            CapNurtac.Entidades.CapDetacapacitacionesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new CapNurtac.Entidades.CapDetacapacitacionesPK();
            key.setCabcapid(Integer.parseInt(values[0]));
            key.setDetacapid(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(CapNurtac.Entidades.CapDetacapacitacionesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCabcapid());
            sb.append(SEPARATOR);
            sb.append(value.getDetacapid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CapDetacapacitaciones) {
                CapDetacapacitaciones o = (CapDetacapacitaciones) object;
                return getStringKey(o.getCapDetacapacitacionesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CapDetacapacitaciones.class.getName()});
                return null;
            }
        }

    }

}
