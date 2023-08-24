package domain.entities.servicios;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Linea extends Entidad{
    private TipoDeTransporte tipoDeTransporte;
    private Establecimiento estacionOrigen;
    private Establecimiento estacionFinal;

    public Linea(String nombre,TipoDeTransporte tipoDeTransporte) {
        super();
        this.nombre = nombre;
        this.tipoDeTransporte = tipoDeTransporte;
    }

}
