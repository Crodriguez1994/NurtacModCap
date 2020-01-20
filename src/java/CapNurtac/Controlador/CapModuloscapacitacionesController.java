package CapNurtac.Controlador;

import CapNurtac.Entidades.CapModuloscapacitaciones;
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

@Named("capModuloscapacitacionesController")
@SessionScoped
public class CapModuloscapacitacionesController implements Serializable {

    @EJB
    private CapNurtac.Controlador.CapModuloscapacitacionesFacade ejbFacade;
    private List<CapModuloscapacitaciones> items = null;
    private CapModuloscapacitaciones selected;

    public CapModuloscapacitacionesController() {
    }

    public CapModuloscapacitaciones getSelected() {
        return selected;
    }

    public void setSelected(CapModuloscapacitaciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCapModuloscapacitacionesPK().setCabcapid(selected.getCapCabcapacitaciones().getCabcapid());
    }

    protected void initializeEmbeddableKey() {
        selected.setCapModuloscapacitacionesPK(new CapNurtac.Entidades.CapModuloscapacitacionesPK());
    }

    private CapModuloscapacitacionesFacade getFacade() {
        return ejbFacade;
    }

    public CapModuloscapacitaciones prepareCreate() {
        selected = new CapModuloscapacitaciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CapModuloscapacitacionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CapModuloscapacitacionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CapModuloscapacitacionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CapModuloscapacitaciones> getItems() {
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

    public CapModuloscapacitaciones getCapModuloscapacitaciones(CapNurtac.Entidades.CapModuloscapacitacionesPK id) {
        return getFacade().find(id);
    }

    public List<CapModuloscapacitaciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CapModuloscapacitaciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CapModuloscapacitaciones.class)
    public static class CapModuloscapacitacionesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CapModuloscapacitacionesController controller = (CapModuloscapacitacionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "capModuloscapacitacionesController");
            return controller.getCapModuloscapacitaciones(getKey(value));
        }

        CapNurtac.Entidades.CapModuloscapacitacionesPK getKey(String value) {
            CapNurtac.Entidades.CapModuloscapacitacionesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new CapNurtac.Entidades.CapModuloscapacitacionesPK();
            key.setCabcapid(Integer.parseInt(values[0]));
            key.setModuloid(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(CapNurtac.Entidades.CapModuloscapacitacionesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCabcapid());
            sb.append(SEPARATOR);
            sb.append(value.getModuloid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CapModuloscapacitaciones) {
                CapModuloscapacitaciones o = (CapModuloscapacitaciones) object;
                return getStringKey(o.getCapModuloscapacitacionesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CapModuloscapacitaciones.class.getName()});
                return null;
            }
        }

    }

}
