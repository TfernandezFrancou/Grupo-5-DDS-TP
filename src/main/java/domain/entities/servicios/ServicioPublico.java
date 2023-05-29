package domain.entities.servicios;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicioPublico {
    private TipoDeTransporte tipoDeTransporte;
    private Linea linea;

    public ServicioPublico(TipoDeTransporte tipoDeTransporte, Linea linea) {
        this.tipoDeTransporte = tipoDeTransporte;
        this.linea = linea;
    }
}
