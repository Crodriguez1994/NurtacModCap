package CapNurtac.Controlador;

import CapNurtac.Entidades.CapDetasistencias;
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

@Named("capDetasistenciasController")
@SessionScoped
public class CapDetasistenciasController implements Serializable {

    @EJB
    private CapNurtac.Controlador.CapDetasistenciasFacade ejbFacade;
    private List<CapDetasistencias> items = null;
    private CapDetasistencias selected;

    public CapDetasistenciasController() {
    }

    public CapDetasistencias getSelected() {
        return selected;
    }

    public void setSelected(CapDetasistencias selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCapDetasistenciasPK().setCabasistenciaid(selected.getCapCabasistencias().getCabasistenciaid());
    }

    protected void initializeEmbeddableKey() {
        selected.setCapDetasistenciasPK(new CapNurtac.Entidades.CapDetasistenciasPK());
    }

    private CapDetasistenciasFacade getFacade() {
        return ejbFacade;
    }

    public CapDetasistencias prepareCreate() {
        selected = new CapDetasistencias();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CapDetasistenciasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CapDetasistenciasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CapDetasistenciasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CapDetasistencias> getItems() {
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

    public CapDetasistencias getCapDetasistencias(CapNurtac.Entidades.CapDetasistenciasPK id) {
        return getFacade().find(id);
    }

    public List<CapDetasistencias> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CapDetasistencias> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CapDetasistencias.class)
    public static class CapDetasistenciasControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CapDetasistenciasController controller = (CapDetasistenciasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "capDetasistenciasController");
            return controller.getCapDetasistencias(getKey(value));
        }

        CapNurtac.Entidades.CapDetasistenciasPK getKey(String value) {
            CapNurtac.Entidades.CapDetasistenciasPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new CapNurtac.Entidades.CapDetasistenciasPK();
            key.setCabasistenciaid(Integer.parseInt(values[0]));
            key.setDetasistenciaid(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(CapNurtac.Entidades.CapDetasistenciasPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCabasistenciaid());
            sb.append(SEPARATOR);
            sb.append(value.getDetasistenciaid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CapDetasistencias) {
                CapDetasistencias o = (CapDetasistencias) object;
                return getStringKey(o.getCapDetasistenciasPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CapDetasistencias.class.getName()});
                return null;
            }
        }

    }

}
