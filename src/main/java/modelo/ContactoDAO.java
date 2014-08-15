package modelo;

import javax.faces.event.ActionEvent;

public interface ContactoDAO extends GenericDAO<Contacto>{

    public void eliminar(int id);
    public void buscar(ActionEvent event);
}
