package domain.entities.servicios;

import domain.entities.services.georef.entities.Localizacion;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Entidad extends Rankeable {
    protected String nombre;
    @Setter
    protected Localizacion localizacion;
    private List<Establecimiento> sucursales;

    public  Entidad(){this.sucursales = new ArrayList<>();};
    public TipoDeTransporte getTipoDeTransporte() {
        return null;
    }

    public void agregarSucursal(Establecimiento nuevo){
        this.sucursales.add(nuevo);
    }
}
