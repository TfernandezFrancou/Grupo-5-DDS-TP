package domain.entities.ranking.Puestos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class PuestoRanking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int puesto_ranking_codigo;
    @Column
    private int puesto;
    @Column
    private double puntaje;

   public PuestoRanking(int puesto, double puntaje){
        this.puesto=puesto;
        this.puntaje=puntaje;
    }
    public PuestoRanking(){}
    public String ocupadoPor(){
        return "No valido";
    }

}
