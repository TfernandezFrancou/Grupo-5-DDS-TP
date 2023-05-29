package domain.entities.repositorios;

import domain.entities.servicios.TipoDeServicio;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class TipoDeServicioRepo {

    private List<TipoDeServicio> tiposDeServicios;

    public TipoDeServicio buscar(String agrupacionServicio, String tipoServicio){

        Optional<TipoDeServicio> tipoEncontrado = tiposDeServicios.stream()
                .filter(tipoDeServicio -> tipoDeServicio.getAgrupacion().getAgrupacion().equals(agrupacionServicio)
                        && tipoDeServicio.getTipoDeServicio().equals(tipoServicio)).findFirst();
        if(tipoEncontrado.isPresent()) return tipoEncontrado.get();
        else return null;
    }

    public TipoDeServicioRepo() {
        this.tiposDeServicios = new ArrayList<>();
    }

    public void agregar(TipoDeServicio tipoDeServicio){
        tiposDeServicios.add(tipoDeServicio);
    }
}
