package domain.entities.repositorios;

import domain.entities.actores.Comunidad;
import domain.entities.incidentes.IncidenteMiembro;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ComunidadesRepo {
    private static ComunidadesRepo instance;
    private List<Comunidad> comunidades;

    private ComunidadesRepo(){
        this.comunidades=new ArrayList<>();
    }
    public static ComunidadesRepo getInstance() {
        if(instance==null){
            instance=new ComunidadesRepo();
        }
        return instance;
    }
    public List<Comunidad>bucarComunidades(){
        EntityManager em = utils.BDUtils.getEntityManager();
        return em.createQuery("select c from Comunidad c ", Comunidad.class).getResultList();
    }
}
