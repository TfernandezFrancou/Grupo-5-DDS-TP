package domain.entities.servicios;

import domain.entities.services.georef.entities.Localizacion;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Entidad {
    protected String nombre;
    @Setter
    protected Localizacion localizacion;

    public TipoDeTransporte getTipoDeTransporte() {
        return null;
    }
}
