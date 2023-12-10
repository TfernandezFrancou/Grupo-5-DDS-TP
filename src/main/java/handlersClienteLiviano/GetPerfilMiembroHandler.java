package handlersClienteLiviano;

import domain.entities.actores.Comunidad;
import domain.entities.actores.miembros.Miembro;
import domain.entities.incidentes.IncidenteMiembro;
import domain.entities.repositorios.ComunidadesRepo;
import domain.entities.sugerencias.RevisionDeIncidentes;
import dto.MiembroPresentacion;
import handlers.SesionManager;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPerfilMiembroHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        Map<String, Object> model = new HashMap<>();
        //String idSesion = context.pathParamAsClass("idSesion", String.class).get();
        String idSesion =context.cookie("id_sesion");
        Miembro miembro = SesionManager.get().obtenerMiembro(idSesion);

        if(miembro!= null){
            List<Comunidad> comunidades = ComunidadesRepo.getInstance().bucarComunidadesMimebro(idSesion);
            model.put("comunidades",comunidades);

            MiembroPresentacion miembroPresentacion= new MiembroPresentacion(miembro);
            model.put("miembro",miembroPresentacion);

            List<IncidenteMiembro> incidentes = RevisionDeIncidentes.getInstance().obtenerIncidentes(miembro);
            model.put("incidentes", incidentes);

            model.put("idSesion",idSesion); //todo: esto para q es?? no esta en la cookie ya?

            context.render("perfil.hbs",model);
        }else {
            context.status(404).json("No tenes una sesion valida");
        }

    }
}
