package domain.entities.actores;

import domain.entities.servicios.Entidad;
import domain.entities.servicios.TipoDeServicio;
import lombok.Getter;

@Getter
public class OrganismoDeControl {
    private String nombre;
    private Entidad entidad;
    private Usuario usuario;

    public OrganismoDeControl(String nombre, Entidad entidad) {
        this.nombre = nombre;
        this.entidad = entidad;
    }
}
