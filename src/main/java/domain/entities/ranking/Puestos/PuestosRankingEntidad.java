package domain.entities.ranking.Puestos;

import domain.entities.servicios.Entidad;

import javax.persistence.*;

@Entity
public class PuestosRankingEntidad extends PuestoRanking{
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "entidad_codigo", referencedColumnName = "entidad_codigo")
    private Entidad ocupadoPor;

    public PuestosRankingEntidad(int puesto, Entidad ocupadoPor, double motivo){
        super(puesto,motivo);
        this.ocupadoPor=ocupadoPor;
    }

    public PuestosRankingEntidad() {

    }

    public String ocupadoPor(){
        return this.ocupadoPor.getNombre();
    }
}
