package beans;

import modelo.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@ManagedBean
@ViewScoped
public class IndexBean extends ContactoDAOImpl implements Serializable{
    private Contacto contacto;
    Entity_Manager entity_manager = new Entity_Manager();

    @PostConstruct
    public void init(){
        contacto = new Contacto();
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public void guardar()
    {
        entity_manager.em.getTransaction().begin();
        entity_manager.em.persist(contacto);
        entity_manager.em.getTransaction().commit();
        contacto = new Contacto();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Contacto guardado correctamente", null));
    }
}
