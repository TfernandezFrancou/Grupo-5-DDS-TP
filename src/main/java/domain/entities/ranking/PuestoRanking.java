package domain.entities.ranking;

import domain.entities.servicios.Rankeable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PuestoRanking {
    private int puesto;
    private Rankeable ocupadoPor;

    private double motivo;

   public PuestoRanking(int puesto, Rankeable ocupadoPor, double motivo){
        this.puesto=puesto;
        this.motivo=motivo;
        this.ocupadoPor=ocupadoPor;
    }
}
