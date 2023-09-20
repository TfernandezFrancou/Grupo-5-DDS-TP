package domain.entities.ranking.Puestos;

import domain.entities.servicios.Entidad;
import domain.entities.servicios.Rankeable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PuestoRanking {
    private int puesto;
    private double motivo;

   public PuestoRanking(int puesto, double motivo){
        this.puesto=puesto;
        this.motivo=motivo;
    }
    public String ocupadoPor(){
        return "No valido";
    }

}
