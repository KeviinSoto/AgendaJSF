package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Entity_Manager {

    public EntityManagerFactory emf;
    public EntityManager em;

    public Entity_Manager()
    {
        emf = Persistence.createEntityManagerFactory("AGENDA_PU");
        em = emf.createEntityManager();
    }
}
