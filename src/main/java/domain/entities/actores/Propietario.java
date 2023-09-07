package domain.entities.actores;

import domain.entities.servicios.ServicioPublico;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table
@Getter
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propietario_codigo;

    @Column
    private String nombre;

    @Transient
    private ServicioPublico servicioPublico;

    @Transient
    private Usuario usuario;

    public Propietario(String nombre, ServicioPublico servicioPublico) {
        this.nombre = nombre;
        this.servicioPublico = servicioPublico;
    }

    public Propietario() {

    }
}
