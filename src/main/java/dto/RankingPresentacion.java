package dto;

import domain.entities.ranking.Ranking;

import java.util.List;

public class RankingPresentacion {
    private List<Ranking> listaRankings;

    public RankingPresentacion(){

    }

    public void setListaRankings(List<Ranking> rankings) {
        listaRankings.addAll(rankings);
    }
}
