package domain.entities.servicios;

import domain.entities.services.georef.entities.Localizacion;
import lombok.Getter;

import java.util.List;

public class Establecimiento {
    private String nombre;
    private List<Servicio> servicios;
    private TipoDeEstablecimiento tipoDeEstablecimiento;
    private Localizacion localizacion;
    @Getter
    private Entidad entidad;
}
