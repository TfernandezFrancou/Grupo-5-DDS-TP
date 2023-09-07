package domain.entities.actores;

import domain.entities.servicios.Entidad;
import domain.entities.servicios.TipoDeServicio;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
@Getter
public class OrganismoDeControl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organismoDeControl_codigo;

    @Column
    private String nombre;

    @Transient
    private Entidad entidad;

    @Transient
    private Usuario usuario;

    public OrganismoDeControl(String nombre, Entidad entidad) {
        this.nombre = nombre;
        this.entidad = entidad;
    }

    public OrganismoDeControl() {

    }
}
