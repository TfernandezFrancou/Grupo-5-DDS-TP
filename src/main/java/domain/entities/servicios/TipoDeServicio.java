package domain.entities.servicios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDeServicio {
    private String tipoDeServicio;
    private AgrupacionServicio agrupacion;

    public TipoDeServicio(String tipoDeServicio, AgrupacionServicio agrupacion) {
        this.tipoDeServicio = tipoDeServicio;
        this.agrupacion = agrupacion;
    }
}
