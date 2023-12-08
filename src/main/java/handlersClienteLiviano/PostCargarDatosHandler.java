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

            String fileName = file.filename();

            InputStream fileContent = file.content();

            String filePath = "src/main/domain.entities/cargaDatos" + fileName;

            java.nio.file.Files.copy(fileContent, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);

            ctx.redirect("/exito");
        } else {
            ctx.redirect("/error");
        }
    }
}