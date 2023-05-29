package domain.entities.servicios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgrupacionServicio {
    private String agrupacion;

    public AgrupacionServicio(String agrupacion) {
        this.agrupacion = agrupacion;
    }
}
