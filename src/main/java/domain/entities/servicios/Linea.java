package domain.entities.servicios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Linea extends Entidad{
    private TipoDeTransporte tipoDeTransporte;

    public Linea(String nombre,TipoDeTransporte tipoDeTransporte) {
        this.nombre = nombre;
        this.tipoDeTransporte = tipoDeTransporte;
    }
}
