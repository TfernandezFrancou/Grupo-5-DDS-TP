package domain.entities.ranking;

import domain.entities.ranking.Puestos.PuestoRanking;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//todo: cuando nos expliquen persistencia no relacional, meterlo en un txt

@Entity
@Table
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ranking_codigo;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<PuestoRanking> puestosRanking;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoRanking_codigo", referencedColumnName = "tipoRanking_codigo")
    private TipoRanking tipoRanking;
    @Column
    private LocalDateTime fecha;

    public Ranking(List<PuestoRanking> puestosRanking, TipoRanking tipoRanking, LocalDateTime fecha){
        this.puestosRanking = puestosRanking;
        this.tipoRanking = tipoRanking;
        this.fecha = fecha;
    }

    public Ranking() {

    }

    public PuestoRanking obtenerPrimerLugar(){

        return this.puestosRanking.get(0);
    }

}
