package domain.entities.servicios;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDeEstablecimiento {
    String tipoEstablecimiento;

    public TipoDeEstablecimiento(String tipo){
        this.tipoEstablecimiento = tipo;
    }
}

