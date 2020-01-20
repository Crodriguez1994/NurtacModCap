package CapNurtac.Controlador;

import CapNurtac.Entidades.CapAsigproyectosector;
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

@Named("capAsigproyectosectorController")
@SessionScoped
public class CapAsigproyectosectorController implements Serializable {

    @EJB
    private CapNurtac.Controlador.CapAsigproyectosectorFacade ejbFacade;
    private List<CapAsigproyectosector> items = null;
    private CapAsigproyectosector selected;

    public CapAsigproyectosectorController() {
    }

    public CapAsigproyectosector getSelected() {
        return selected;
    }

    public void setSelected(CapAsigproyectosector selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCapAsigproyectosectorPK().setProyectoid(selected.getCapProyectos().getProyectoid());
    }

    protected void initializeEmbeddableKey() {
        selected.setCapAsigproyectosectorPK(new CapNurtac.Entidades.CapAsigproyectosectorPK());
    }

    private CapAsigproyectosectorFacade getFacade() {
        return ejbFacade;
    }

    public CapAsigproyectosector prepareCreate() {
        selected = new CapAsigproyectosector();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CapAsigproyectosectorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CapAsigproyectosectorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CapAsigproyectosectorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CapAsigproyectosector> getItems() {
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

    public CapAsigproyectosector getCapAsigproyectosector(CapNurtac.Entidades.CapAsigproyectosectorPK id) {
        return getFacade().find(id);
    }

    public List<CapAsigproyectosector> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CapAsigproyectosector> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CapAsigproyectosector.class)
    public static class CapAsigproyectosectorControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CapAsigproyectosectorController controller = (CapAsigproyectosectorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "capAsigproyectosectorController");
            return controller.getCapAsigproyectosector(getKey(value));
        }

        CapNurtac.Entidades.CapAsigproyectosectorPK getKey(String value) {
            CapNurtac.Entidades.CapAsigproyectosectorPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new CapNurtac.Entidades.CapAsigproyectosectorPK();
            key.setAsigid(Integer.parseInt(values[0]));
            key.setProyectoid(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(CapNurtac.Entidades.CapAsigproyectosectorPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAsigid());
            sb.append(SEPARATOR);
            sb.append(value.getProyectoid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CapAsigproyectosector) {
                CapAsigproyectosector o = (CapAsigproyectosector) object;
                return getStringKey(o.getCapAsigproyectosectorPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CapAsigproyectosector.class.getName()});
                return null;
            }
        }

    }

}
