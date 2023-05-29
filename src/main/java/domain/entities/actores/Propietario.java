package domain.entities.actores;

import domain.entities.servicios.ServicioPublico;
import lombok.Getter;

import java.util.List;
@Getter
public class Propietario {
    private String nombre;
    private ServicioPublico servicioPublico;
    private Usuario usuario;

    public Propietario(String nombre, ServicioPublico servicioPublico) {
        this.nombre = nombre;
        this.servicioPublico = servicioPublico;
    }
}
