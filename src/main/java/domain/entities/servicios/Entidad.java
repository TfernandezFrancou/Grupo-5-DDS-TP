package domain.entities.servicios;

import lombok.Getter;

@Getter
public abstract class Entidad {
    protected String nombre;

    public TipoDeTransporte getTipoDeTransporte() {
        return null;
    }
}
