package domain.entities.ranking;

import domain.entities.ranking.FormasRankings.FormaRanking;

import java.util.List;

public class GeneradorDeRankings {

    private List<FormaRanking> formasRanking;

    public void generarRanking(){
        for (FormaRanking formaRanking : formasRanking) {
            formaRanking.generar();
        }
    }
}
