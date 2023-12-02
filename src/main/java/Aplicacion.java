import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import handlers.*;
import handlersClienteLiviano.GetRankingLivianoHandler;
import handlersClienteLiviano.GetRankingsLivianoHandler;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.json.JavalinJackson;
import org.quartz.SchedulerException;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import io.javalin.http.HttpStatus;
import io.javalin.rendering.JavalinRenderer;

import java.io.IOException;


public class Aplicacion {
    public static void main(String[] args) throws SchedulerException {
        initTemplateEngine();
        Javalin app = Javalin.create(javalinConfig -> {
                    javalinConfig.plugins.enableCors(cors -> {cors.add(it -> it.anyHost());}); // para poder hacer requests de un dominio a otro
                    javalinConfig.staticFiles.add("/"); // recursos estáticos (HTML, CSS, JS, IMG)
                    javalinConfig.jsonMapper(new JavalinJackson().updateMapper(mapper ->
                            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)));
                }
                ).get("/", ctx -> ctx.result("Hello World"))
                .start(4567);

        System.out.println("Visit http://localhost:4567/static/loginPage.html");

        // Handlers
        // Cliente Pesado
        app.get("/api/incidentes", new GetIncidentesHandler());
        app.get("/api/rankings", new GetRankingsHandler());
        app.post("/api/agregarIncidente", new PostIncidenteHandler());
        app.get("/api/ranking/{id}",new GetRankingHandler());
        app.get("/api/establecimientos", new GetEstablecimientosHandler());
        app.post("/api/login", new LoginHandler());
        //Cliente Liviano
        app.get("/api/rankingsLiviano",new GetRankingsLivianoHandler());
        app.get("/api/rankingLiviano/{id}",new GetRankingLivianoHandler());

    }
    private static void initTemplateEngine() {
        JavalinRenderer.register(
                (path, model, context) -> { // Función que renderiza el template
                    Handlebars handlebars = new Handlebars();
                    Template template = null;
                    try {
                        template = handlebars.compile("templates/" + path.replace(".hbs", ""));
                        return template.apply(model);
                    } catch (IOException e) {
                        //
                        e.printStackTrace();
                        context.status(HttpStatus.NOT_FOUND);
                        return "No se encuentra la página indicada...";
                    }
                }, ".hbs" // Extensión del archivo de template
        );
    }
}
