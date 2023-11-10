import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import handlers.GetIncidentesHandler;
import io.javalin.json.JavalinJackson;
import org.quartz.SchedulerException;

public class Aplicacion {
    public static void main(String[] args) throws SchedulerException {
        Javalin app = Javalin.create(javalinConfig -> {
                    javalinConfig.staticFiles.add("/"); // recursos estáticos (HTML, CSS, JS, IMG)
                    javalinConfig.jsonMapper(new JavalinJackson().updateMapper(mapper ->
                            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)));
                }
                ).get("/", ctx -> ctx.result("Hello World"))
                .start(4567);

        System.out.println("Visit http://localhost:4567/static/loginPage.html");

        // Handlers
        app.get("/incidentes", new GetIncidentesHandler());
    }
}
