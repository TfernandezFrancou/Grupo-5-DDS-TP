package handlersClienteLiviano;

import domain.entities.comparadores.ComparaPuestoRanking;
import domain.entities.ranking.Puestos.PuestoRanking;
import domain.entities.ranking.Ranking;
import domain.entities.ranking.TipoRanking;
import domain.entities.repositorios.RankingsRepo;


import java.io.IOException;
import java.util.*;

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
        TipoRanking tipoRanking=ranking.get().getTipoRanking();
        List<PuestoRanking> puestosRanking=ranking.get().getPuestosRanking();
        System.out.println(puestosRanking.size());
        Collections.sort(puestosRanking,new ComparaPuestoRanking());

        for(PuestoRanking puesto:puestosRanking){
            System.out.println(puesto.getPuesto());
            System.out.println(puesto.getPuntaje());
            System.out.println(puesto.ocupadoPor());
        }


        model.put("puestosRanking", puestosRanking);
        switch(tipoRanking.getTipoRanking_codigo()){
            case 1:
                ctx.render("ranking2.hbs", model);
            break;
            case 2:
                ctx.render("ranking.hbs", model);
            break;
            case 3:
                ctx.render("ranking3.hbs", model);
            break;
        }





    }


}