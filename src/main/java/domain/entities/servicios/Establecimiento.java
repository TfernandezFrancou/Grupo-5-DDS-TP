package domain.entities.servicios;

import domain.entities.services.georef.entities.Localizacion;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int establecimiento_codigo;
    @Column
    private String nombre;
    @Transient
    private List<Servicio> servicios;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoDeEstablecimiento_codigo", referencedColumnName = "tipoDeEstablecimiento_codigo")
    private TipoDeEstablecimiento tipoDeEstablecimiento;
    @Transient
    private Localizacion localizacion;

    @Transient
    @Getter
    private Entidad entidad;

    public Establecimiento(String nombre, TipoDeEstablecimiento tipoDeEstablecimiento, Entidad entidad){
        this.servicios = new ArrayList<>();
        this.nombre = nombre;
        this.tipoDeEstablecimiento= tipoDeEstablecimiento;
        this.entidad = entidad;
    }

    public Establecimiento() {

    }

    public void agregarServicio(Servicio servicio){
        this.servicios.add(servicio);
    }
}
