package dto;

import domain.entities.ranking.Puestos.PuestoRanking;
import domain.entities.ranking.Ranking;
import domain.entities.ranking.TipoRanking;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.List;
@Getter
public class RankingPresentacion {
    private List<PuestoRanking> puestosRanking;
    private TipoRanking tipoRanking;
    private String fecha;

    public RankingPresentacion(Ranking ranking){
        this.puestosRanking=ranking.getPuestosRanking();
        this.tipoRanking= ranking.getTipoRanking();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        this.fecha= ranking.getFecha().format(formatter);
    }

}
