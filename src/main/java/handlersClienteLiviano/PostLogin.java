package handlersClienteLiviano;

import domain.entities.actores.miembros.Miembro;
import domain.entities.repositorios.RepoMiembros;
import dto.LoginRequest;
import handlers.SesionManager;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

public class PostLogin implements Handler {

    public PostLogin(){}
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        //validamos user/pass y buscamos datos de ese usuario para agregar en la sesión
        System.out.println(ctx.formParam("username"));
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(ctx.formParam("username"));
        loginRequest.setPassword(ctx.formParam("password"));

        //todo: hacer que se puedan logear todos, una clase abstracta "logeable" x ej
        Miembro miembroObtenido = RepoMiembros.getInstance().buscarMiembroUsuario(loginRequest);
        if(miembroObtenido.getMiembro_codigo()!=-1){
        SesionManager sesionManager = SesionManager.get();
        String idSesion = sesionManager.crearSesion("usuario", miembroObtenido);
        sesionManager.agregarAtributo(idSesion, "fechaInicio", LocalDateTime.now());
        sesionManager.agregarAtributo(idSesion, "rol", miembroObtenido.getUsuario().getRol());
        System.out.println("Login: " + loginRequest);
        System.out.println("Login: " + miembroObtenido.getNombre());
        System.out.println("Login: " + idSesion);

        ctx.cookie("id_sesion",idSesion);

        ctx.redirect("/perfil");
        }
        else{ctx.redirect("/loginFail");}




    }
}
