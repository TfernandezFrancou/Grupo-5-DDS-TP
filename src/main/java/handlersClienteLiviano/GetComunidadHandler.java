package handlersClienteLiviano;

import domain.entities.actores.Comunidad;
import domain.entities.actores.miembros.MiembroPorComunidad;
import domain.entities.repositorios.ComunidadesRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetComunidadHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        Map<String, Object> model = new HashMap<>();
        Integer idBuscado = context.pathParamAsClass("id", Integer.class).get();
        Comunidad comunidad = ComunidadesRepo.getInstance().buscarComunidadPorId(idBuscado);

        // Agregar la información relevante al modelo
        model.put("nombreComunidad", comunidad.getNombre());
        model.put("objetivoComunidad", comunidad.getObjetivo());

        // Lista de miembros con sus nombres
        List<String> nombresMiembros = new ArrayList<>();
        for (MiembroPorComunidad miembrosPorComunidad : comunidad.getMiembros()) {
            nombresMiembros.add(miembrosPorComunidad.getMiembro().getNombre()+", "+ miembrosPorComunidad.getMiembro().getApellido());
        }
        if(nombresMiembros.isEmpty()){
            nombresMiembros.add("No hay miembros por el momento");
        }
        model.put("nombresMiembros", nombresMiembros);

        // Lista de administradores con sus nombres
        List<String> nombresAdministradores = new ArrayList<>();

        for (MiembroPorComunidad admin : comunidad.getMiembros().stream().filter(MiembroPorComunidad::getEsAdmin).collect(Collectors.toList())) {
                nombresAdministradores.add(admin.getMiembro().getNombre()+", "+ admin.getMiembro().getApellido());
        }

        if(nombresAdministradores.isEmpty()){
            nombresAdministradores.add("No hay administradores por el momento");
        }
        model.put("nombresAdministradores", nombresAdministradores);


        context.render("perfil_comunidad.hbs", model);
    }
}
