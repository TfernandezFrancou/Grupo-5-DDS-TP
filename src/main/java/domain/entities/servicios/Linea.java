package domain.entities.servicios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Linea {
    private String nombre;

    public Linea(String nombre) {
        this.nombre = nombre;
    }
}
