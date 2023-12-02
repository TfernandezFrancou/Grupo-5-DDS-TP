package handlersClienteLiviano;

import domain.entities.ranking.Puestos.PuestoRanking;
import domain.entities.ranking.Ranking;
import domain.entities.ranking.TipoRanking;
import domain.entities.repositorios.RankingsRepo;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

public class GetRankingLivianoHandler implements Handler {
    private RankingsRepo repo;

    public GetRankingLivianoHandler() {
        super();
        this.repo = RankingsRepo.getInstance();
    }

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Map<String, Object> model = new HashMap<>();
        Integer idBuscado = ctx.pathParamAsClass("id", Integer.class).get();
        List<Ranking> rankings = repo.buscarRankings();
        Optional<Ranking> ranking= rankings.stream().filter(r->r.getRanking_codigo()==idBuscado).findFirst();
        String tipoRanking=ranking.get().getTipoRanking().getNombre();
        System.out.println(tipoRanking);
        List<PuestoRanking> puestosRanking=ranking.get().getPuestosRanking();
        model.put("puestosranking", puestosRanking);
        if(tipoRanking=="Mayor Cantidad de Incidentes"){
            ctx.render("ranking.hbs", model);
        } else if(tipoRanking=="Mayor Tiempo Promedio"){
            ctx.render("ranking2.hbs", model);
        }else{
            ctx.render("ranking3.hbs", model);
        }






    }}