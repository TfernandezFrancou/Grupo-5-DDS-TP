package domain.entities.ranking.Puestos;

import domain.entities.servicios.Entidad;
import domain.entities.servicios.Rankeable;
import lombok.Getter;


public class PuestosRankingEntidad extends PuestoRanking{
    private Entidad ocupadoPor;

    public PuestosRankingEntidad(int puesto, Entidad ocupadoPor, double motivo){
        super(puesto,motivo);
        this.ocupadoPor=ocupadoPor;
    }
    public String ocupadoPor(){
        return this.ocupadoPor.getNombre();
    }
}
