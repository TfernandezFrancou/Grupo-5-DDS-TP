package handlers;

import domain.entities.incidentes.IncidenteMiembro;
import dto.IncidentePresentacion;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import utils.BDUtils;

import javax.persistence.EntityManager;

public class PostIncidenteHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        IncidentePresentacion incidentePost =context.bodyAsClass(IncidentePresentacion.class);

        //Podriamos agregar validacion de que sea un servicio y establecimiento de la BD pero no lo creo necesario
        System.out.println(incidentePost.getEstablecimiento());
        System.out.println(incidentePost.getServicio());
        System.out.println(incidentePost.getFechaCreacion());
        System.out.println(incidentePost.getDescripcion());
        System.out.println(incidentePost.getIdComunidad());
        System.out.println(incidentePost.getIdSesion());

        IncidenteMiembro incidente = incidentePost.generarIncidente();
        EntityManager em = utils.BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);
        em.persist(incidente);
        BDUtils.commit(em);
        context.status(202);
    }
}
