package handlers;

import domain.entities.repositorios.IncidentesRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetIncidentesHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        context.json(IncidentesRepo.getInstance().buscarIncidentes());
    }
}
