package handlers;

import domain.entities.incidentes.IncidenteMiembro;
import dto.IncidentePresentacion;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class PostIncidenteHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        IncidentePresentacion incidentePost =context.bodyAsClass(IncidentePresentacion.class);

        //Podriamos agregar validacion de que sea un servicio y establecimiento de la BD pero no lo creo necesario
        System.out.println(incidentePost.getEstablecimiento());
        System.out.println(incidentePost.getServicio());
        System.out.println(incidentePost.getFechaCreacion());

        //Aca hay que crear el incidente miembro, pero como requiere un miembro por comunidad y no esta hecho lo de
        // sesion entonces lo hacemos desp por ahora printea lo que recibe
        context.status(200);
        context.result("Incidente recibido correctamente");

    }
}
