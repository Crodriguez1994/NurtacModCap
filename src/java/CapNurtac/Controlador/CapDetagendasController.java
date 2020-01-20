package CapNurtac.Controlador;

import CapNurtac.Entidades.CapDetagendas;
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

@Named("capDetagendasController")
@SessionScoped
public class CapDetagendasController implements Serializable {

    @EJB
    private CapNurtac.Controlador.CapDetagendasFacade ejbFacade;
    private List<CapDetagendas> items = null;
    private CapDetagendas selected;

    public CapDetagendasController() {
    }

    public CapDetagendas getSelected() {
        return selected;
    }

    public void setSelected(CapDetagendas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCapDetagendasPK().setCabagendaid(selected.getCapCabagendas().getCabagendaid());
    }

    protected void initializeEmbeddableKey() {
        selected.setCapDetagendasPK(new CapNurtac.Entidades.CapDetagendasPK());
    }

    private CapDetagendasFacade getFacade() {
        return ejbFacade;
    }

    public CapDetagendas prepareCreate() {
        selected = new CapDetagendas();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CapDetagendasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CapDetagendasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CapDetagendasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CapDetagendas> getItems() {
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

    public CapDetagendas getCapDetagendas(CapNurtac.Entidades.CapDetagendasPK id) {
        return getFacade().find(id);
    }

    public List<CapDetagendas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CapDetagendas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CapDetagendas.class)
    public static class CapDetagendasControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CapDetagendasController controller = (CapDetagendasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "capDetagendasController");
            return controller.getCapDetagendas(getKey(value));
        }

        CapNurtac.Entidades.CapDetagendasPK getKey(String value) {
            CapNurtac.Entidades.CapDetagendasPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new CapNurtac.Entidades.CapDetagendasPK();
            key.setCabagendaid(Integer.parseInt(values[0]));
            key.setDetagendaid(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(CapNurtac.Entidades.CapDetagendasPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCabagendaid());
            sb.append(SEPARATOR);
            sb.append(value.getDetagendaid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CapDetagendas) {
                CapDetagendas o = (CapDetagendas) object;
                return getStringKey(o.getCapDetagendasPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CapDetagendas.class.getName()});
                return null;
            }
        }

    }

}
