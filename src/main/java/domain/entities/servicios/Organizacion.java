package domain.entities.servicios;

import domain.entities.services.georef.entities.Localizacion;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Organizacion extends Entidad {
    private String tipoOrg;


    public Organizacion(String nombre, String tipoOrg) {
        this.nombre = nombre;
        this.tipoOrg = tipoOrg;
    }
}
