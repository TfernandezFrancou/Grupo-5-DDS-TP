package handlers;

import domain.entities.incidentes.IncidenteMiembro;
import domain.entities.repositorios.IncidentesRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import dto.IncidentePresentacion;

import java.util.ArrayList;
import java.util.List;

public class GetIncidentesHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        List<IncidenteMiembro> incidentesMiembro = IncidentesRepo.getInstance().buscarIncidentes();
        List<IncidentePresentacion> incidentes=new ArrayList<>();
        for(IncidenteMiembro incidente : incidentesMiembro ){
            IncidentePresentacion unIncidente = new IncidentePresentacion(incidente);
            incidentes.add(unIncidente);
        }
        context.json(incidentes);
    }
}
