import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import handlers.PostIncidenteHandler;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import handlers.GetIncidentesHandler;
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
        app.get("/incidentes", new GetIncidentesHandler());
        app.post("/agregarIncidente", new PostIncidenteHandler());
    }
}
