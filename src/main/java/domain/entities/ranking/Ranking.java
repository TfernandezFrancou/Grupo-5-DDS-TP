package domain.entities.ranking;

import domain.entities.servicios.Rankeable;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Ranking {

    private List<Rankeable> ranking;
    private TipoRanking tipoRanking;
    private LocalDateTime fecha;

    public Ranking(List<Rankeable> ranking, TipoRanking tipoRanking, LocalDateTime fecha){
        this.ranking = ranking;
        this.tipoRanking = tipoRanking;
        this.fecha = fecha;
    }

}
