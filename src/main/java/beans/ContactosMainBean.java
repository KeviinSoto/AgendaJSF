package beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import modelo.*;


@ManagedBean
@ViewScoped
public class ContactosMainBean extends ContactoDAOImpl implements Serializable {
    private List<Contacto> contactosList;
    private String texto_a_buscar;
    Entity_Manager entity_manager = new Entity_Manager();


    public String getTexto_a_buscar() {
        return texto_a_buscar;
    }

    public void setTexto_a_buscar(String texto_a_buscar) {
        this.texto_a_buscar = texto_a_buscar;
    }

    @PostConstruct
    private void init() {
        contactosList = entity_manager.em.createNamedQuery("findAllContacts").getResultList();
    }

    public List<Contacto> getContactosList() {
        return contactosList;
    }

    public void eliminar(int id)
    {
        Contacto contacto_1 = entity_manager.em.find(Contacto.class, id);
        entity_manager.em.getTransaction().begin();
        entity_manager.em.remove(contacto_1);
        contactosList = entity_manager.em.createNamedQuery("findAllContacts").getResultList();
        entity_manager.em.getTransaction().commit();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("modelo.Contacto eliminado correctamente", null));
    }

    public void buscar(ActionEvent event){
       contactosList = entity_manager.em.createQuery("SELECT c FROM Contacto c where c.nombre = :nombre1").setParameter("nombre1", texto_a_buscar).getResultList();
    }

}
