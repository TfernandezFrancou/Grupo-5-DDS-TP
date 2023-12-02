package handlersClienteLiviano;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import domain.entities.ranking.Ranking;
import domain.entities.repositorios.RankingsRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import org.jetbrains.annotations.NotNull;

public class GetRankingsLivianoHandler implements Handler {
    private RankingsRepo repo;

    public GetRankingsLivianoHandler() {
        super();
        this.repo = RankingsRepo.getInstance();
    }

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = new HashMap<>();
        List<Ranking> rankings = repo.buscarRankings();


        model.put("rankings", rankings);
        ctx.render("VistasRanking.hbs", model);

    }

}
