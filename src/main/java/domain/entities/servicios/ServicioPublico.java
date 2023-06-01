package domain.entities.servicios;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ServicioPublico {
    private TipoDeTransporte tipoDeTransporte;
    private List<Linea> lineas;

    public ServicioPublico(TipoDeTransporte tipoDeTransporte) {
        this.tipoDeTransporte = tipoDeTransporte;
        this.lineas=new ArrayList<>();
    }
}
