package domain.entities.repositorios;

import domain.entities.incidentes.Incidente;
import domain.entities.ranking.Ranking;

import java.util.ArrayList;
import java.util.List;

public class RankingsRepo {
    private static RankingsRepo instance;
    private List<Ranking> rankings;


    private RankingsRepo() {
        this.rankings = new ArrayList<>();
    }

    public static RankingsRepo getInstance () {
        if (instance == null) {
            instance = new RankingsRepo();
        }
        return instance;
    }

    public void agregarRanking(Ranking ranking){this.rankings.add(ranking);}
}
