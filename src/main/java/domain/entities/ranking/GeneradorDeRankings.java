package domain.entities.ranking;

import domain.entities.ranking.FormasRankings.FormaRanking;
import domain.entities.ranking.FormasRankings.MayorCantidadIncidentes;
import domain.entities.ranking.FormasRankings.MayorGradoImpacto;
import domain.entities.ranking.FormasRankings.MayorTiempoPromedio;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class GeneradorDeRankings {

    private List<FormaRanking> formasRanking;
    private LocalDateTime fechaRealizacion;

    public GeneradorDeRankings(){
        this.formasRanking= new ArrayList<>();
        formasRanking.add(new MayorCantidadIncidentes());
        formasRanking.add(new MayorGradoImpacto());
        formasRanking.add(new MayorTiempoPromedio());
    }
    public void generarRanking(){
        for (FormaRanking formaRanking : formasRanking) {
            formaRanking.generar(this.fechaRealizacion);
        }
    }
}
