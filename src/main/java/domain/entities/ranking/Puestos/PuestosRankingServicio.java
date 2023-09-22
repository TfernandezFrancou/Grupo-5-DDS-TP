package domain.entities.ranking.Puestos;

import domain.entities.servicios.Entidad;
import domain.entities.servicios.Servicio;
import lombok.Getter;

import javax.persistence.*;

@Entity
public class PuestosRankingServicio extends PuestoRanking{
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_codigo", referencedColumnName = "servicio_codigo")
    private Servicio ocupadoPor;
    public PuestosRankingServicio(int puesto, Servicio ocupadoPor, double motivo){
        super(puesto,motivo);
        this.ocupadoPor=ocupadoPor;
    }

    public PuestosRankingServicio() {

    }
   /* public String ocupadoPor(){
        return this.ocupadoPor.getNombre();
    }*/
}
