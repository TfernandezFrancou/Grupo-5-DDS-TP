package handlersClienteLiviano;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.UploadedFile;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class PostCargarDatosHandler implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        List<UploadedFile> files = ctx.uploadedFiles("archivo");

        if (files != null && !files.isEmpty()) {
            UploadedFile file = files.get(0);

            // Obtiene el nombre del archivo
            String fileName = file.filename();

            // Obtiene el contenido del archivo como InputStream
            InputStream fileContent = file.content();

            // Define la ruta donde se guardará el archivo (cambia según tus necesidades)
            String filePath = "src/main/domain.entities/cargaDatos" + fileName;

            // Guarda el archivo en el servidor
            java.nio.file.Files.copy(fileContent, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Procesa el archivo según tus necesidades
            // ...

            // Muestra un mensaje de éxito o realiza redireccionamiento
            ctx.redirect("/exito");
        } else {
            // No se subió ningún archivo, maneja según tus necesidades
            ctx.redirect("/error");
        }
    }
}