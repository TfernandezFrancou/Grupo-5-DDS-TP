package domain.entities.servicios;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table
public abstract class Servicio extends Rankeable {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int servicio_codigo;*/
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "establecimiento_codigo", referencedColumnName = "establecimiento_codigo")
    protected Establecimiento establecimiento;

}
