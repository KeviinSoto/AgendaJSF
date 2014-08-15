package beans;

import modelo.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class EditarBean extends ContactoDAOImpl implements Serializable{
    private Contacto contacto;
    private int id_a_mandar;
    Entity_Manager entity_manager = new Entity_Manager();

    public int getId_a_mandar() {
        return id_a_mandar;
    }

    public void setId_a_mandar(int id_a_mandar) {
        this.id_a_mandar = id_a_mandar;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @PostConstruct
    public void init(){
        contacto = new Contacto();
        id_a_mandar = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id1"));
        entity_manager.em.getTransaction().begin();
        List<Contacto> lista = entity_manager.em.createQuery("SELECT c FROM Contacto c where c.id = :nombre1").setParameter("nombre1", id_a_mandar).getResultList();
        for (Contacto contacto1 : lista){
            contacto.setNombre(contacto1.getNombre());
            contacto.setApellido(contacto1.getApellido());
            contacto.setTelefono(contacto1.getTelefono());
            contacto.setCelular(contacto1.getCelular());
            contacto.setEmail(contacto1.getEmail());
        }
        entity_manager.em.getTransaction().commit();
    }

    public void modificar()
    {
       entity_manager.em.getTransaction().begin();
        Contacto contacto1 = entity_manager.em.find(Contacto.class, id_a_mandar);
        contacto1.setNombre(contacto.getNombre());
        contacto1.setApellido(contacto.getApellido());
        contacto1.setTelefono(contacto.getTelefono());
        contacto1.setCelular(contacto.getCelular());
        contacto1.setEmail(contacto.getEmail());
        entity_manager.em.getTransaction().commit();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Contacto actualizado correctamente", null));
    }


}
