package domain.entities.repositorios;

import domain.entities.actores.Comunidad;
import domain.entities.actores.miembros.Miembro;
import domain.entities.actores.miembros.MiembroPorComunidad;
import domain.entities.incidentes.IncidenteMiembro;
import handlers.SesionManager;

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
    public Comunidad buscarComunidadPorId(int codigoComunidad) {
        EntityManager em = utils.BDUtils.getEntityManager();
        List<Comunidad> comunidades = em.createQuery("SELECT c FROM Comunidad c WHERE c.comunidad_codigo = :codigoComunidad", Comunidad.class)
                .setParameter("codigoComunidad", codigoComunidad)
                .getResultList();
        return comunidades.get(0);
    }
    public List<Comunidad> bucarComunidadesMimebro(String idSesion){
       List<Comunidad> comunidades = new ArrayList<>();
        Miembro miembro= SesionManager.get().obtenerMiembro(idSesion);
        for(MiembroPorComunidad miembroPorComunidad: miembro.getComunidades() ){
            comunidades.add(miembroPorComunidad.getComunidad());
        }
       return comunidades;
    }
}
