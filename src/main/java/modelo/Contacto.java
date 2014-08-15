package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name= "datos")
@NamedQueries({
        @NamedQuery(name = "findAllContacts", query = "SELECT c FROM Contacto c")
})
public class Contacto implements Serializable{

    @Id
    @Column(name="iddatos")
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String celular;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

