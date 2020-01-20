package CapNurtac.Controlador;

import CapNurtac.Entidades.CapDetahorarios;
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

@Named("capDetahorariosController")
@SessionScoped
public class CapDetahorariosController implements Serializable {

    @EJB
    private CapNurtac.Controlador.CapDetahorariosFacade ejbFacade;
    private List<CapDetahorarios> items = null;
    private CapDetahorarios selected;

    public CapDetahorariosController() {
    }

    public CapDetahorarios getSelected() {
        return selected;
    }

    public void setSelected(CapDetahorarios selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCapDetahorariosPK().setCabhorarioid(selected.getCapCabhorarios().getCabhorarioid());
    }

    protected void initializeEmbeddableKey() {
        selected.setCapDetahorariosPK(new CapNurtac.Entidades.CapDetahorariosPK());
    }

    private CapDetahorariosFacade getFacade() {
        return ejbFacade;
    }

    public CapDetahorarios prepareCreate() {
        selected = new CapDetahorarios();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CapDetahorariosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CapDetahorariosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CapDetahorariosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CapDetahorarios> getItems() {
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

    public CapDetahorarios getCapDetahorarios(CapNurtac.Entidades.CapDetahorariosPK id) {
        return getFacade().find(id);
    }

    public List<CapDetahorarios> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CapDetahorarios> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CapDetahorarios.class)
    public static class CapDetahorariosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CapDetahorariosController controller = (CapDetahorariosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "capDetahorariosController");
            return controller.getCapDetahorarios(getKey(value));
        }

        CapNurtac.Entidades.CapDetahorariosPK getKey(String value) {
            CapNurtac.Entidades.CapDetahorariosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new CapNurtac.Entidades.CapDetahorariosPK();
            key.setCabhorarioid(Integer.parseInt(values[0]));
            key.setDetahorarioid(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(CapNurtac.Entidades.CapDetahorariosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCabhorarioid());
            sb.append(SEPARATOR);
            sb.append(value.getDetahorarioid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CapDetahorarios) {
                CapDetahorarios o = (CapDetahorarios) object;
                return getStringKey(o.getCapDetahorariosPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CapDetahorarios.class.getName()});
                return null;
            }
        }

    }

}
