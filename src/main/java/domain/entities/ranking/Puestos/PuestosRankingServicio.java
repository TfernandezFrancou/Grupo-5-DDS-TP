package domain.entities.ranking.Puestos;

import domain.entities.servicios.Entidad;
import domain.entities.servicios.Servicio;
import lombok.Getter;

public class PuestosRankingServicio extends PuestoRanking{
    private Servicio ocupadoPor;
    public PuestosRankingServicio(int puesto, Servicio ocupadoPor, double motivo){
        super(puesto,motivo);
        this.ocupadoPor=ocupadoPor;
    }
    public String ocupadoPor(){
        return this.ocupadoPor.getNombre();
    }
}
