package handlersClienteLiviano;

import domain.entities.ranking.Ranking;
import domain.entities.repositorios.RankingsRepo;
import io.javalin.http.Handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GetRankingLivianoHandler implements Handler {
    private RankingsRepo repo;

    public GetRankingLivianoHandler() {
        super();
        this.repo = RankingsRepo.getInstance();
    }

    @Override
    public void handle(Context ctx) throws Exception {
        Map<String, Object> model = new HashMap<>();
        Integer idBuscado = context.pathParamAsClass("id", Integer.class).get();
        List<Ranking> rankings = repo.buscarRankings();
        Optional<Ranking> ranking= rankings.stream().filter(r->r.getRanking_codigo()==idBuscado).findFirst();


        model.put("ranking", ranking);

        ctx.render("ranking.hbs", model);

    }