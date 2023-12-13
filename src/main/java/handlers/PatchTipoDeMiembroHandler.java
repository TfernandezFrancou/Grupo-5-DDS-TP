package handlers;

import domain.entities.actores.miembros.Miembro;
import domain.entities.actores.miembros.MiembroPorComunidad;
import domain.entities.actores.miembros.TipoDeMiembro;
import domain.entities.repositorios.ComunidadesRepo;
import domain.entities.repositorios.RepoMiembros;
import dto.PatchTipoMiembroResponse;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;
import utils.BDUtils;

import javax.persistence.EntityManager;

public class PatchTipoDeMiembroHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        String tipoDeMiembro=context.formParamAsClass("tipoMiembro",String.class).get();
        int idComunidad=context.formParamAsClass("idComunidad", int.class).get();
        String id_sesion=context.cookie("id_sesion");
        Miembro miembro= SesionManager.get().obtenerMiembro(id_sesion);
        System.out.println("Se manda el form");
        System.out.println(tipoDeMiembro);

        MiembroPorComunidad miembroPorComunidad = ComunidadesRepo.getInstance().obtenerMiembroPorComunidad(miembro.getMiembro_codigo(),idComunidad);
        EntityManager em = utils.BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);
        MiembroPorComunidad miembroACambiar = em.find(MiembroPorComunidad.class,miembroPorComunidad.getMiembroPorComunidad_codigo());

        if(tipoDeMiembro.equalsIgnoreCase("Observador")){
            TipoDeMiembro nuevoTipo= RepoMiembros.getInstance().buscarTipoDeMiembro("Observador");
            miembroACambiar.setTipoDeMiembro(nuevoTipo);
        }
        else{
            TipoDeMiembro nuevoTipo=RepoMiembros.getInstance().buscarTipoDeMiembro("Usuario de Servicio");
            miembroACambiar.setTipoDeMiembro(nuevoTipo);
        }
        BDUtils.commit(em);
        context.redirect("/perfil");
    }
}
