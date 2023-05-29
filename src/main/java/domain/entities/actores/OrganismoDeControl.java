package domain.entities.actores;

import domain.entities.servicios.TipoDeServicio;
import lombok.Getter;

@Getter
public class OrganismoDeControl {
    private String nombre;
    private TipoDeServicio tipoDeServicio;
    private Usuario usuario;

    public OrganismoDeControl(String nombre, TipoDeServicio tipoDeServicio) {
        this.nombre = nombre;
        this.tipoDeServicio = tipoDeServicio;
    }
}
