package domain.entities.ranking;

import domain.entities.servicios.Rankeable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

//todo: cuando nos expliquen persistencia no relacional, meterlo en un txt

@Entity
@Table
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ranking_codigo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<PuestoRanking> ranking;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoRanking_codigo", referencedColumnName = "tipoRanking_codigo")
    private TipoRanking tipoRanking;
    @Column
    private LocalDateTime fecha;

    public Ranking(List<PuestoRanking> ranking, TipoRanking tipoRanking, LocalDateTime fecha){
        this.ranking = ranking;
        this.tipoRanking = tipoRanking;
        this.fecha = fecha;
    }

    public Ranking() {

    }

    public Rankeable obtenerPrimerLugar(){
        return this.ranking.get(0).getOcupadoPor();
    }

}
