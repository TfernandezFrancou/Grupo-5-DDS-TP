import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import handlers.*;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.json.JavalinJackson;
import org.quartz.SchedulerException;

public class Aplicacion {
    public static void main(String[] args) throws SchedulerException {
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
        app.get("/api/incidentes", new GetIncidentesHandler());
        app.get("/api/rankings", new GetRankingsHandler());
        app.post("/api/agregarIncidente", new PostIncidenteHandler());
        app.get("/api/ranking/{id}",new GetRankingHandler());
        app.get("/api/establecimientos", new GetEstablecimientosHandler());
        app.post("/api/login", new LoginHandler());
    }
}
