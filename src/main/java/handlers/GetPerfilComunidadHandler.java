package handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetPerfilComunidadHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) throws Exception {
        String idSesion=context.cookie("id_sesion");

    }
}
