package domain.entities.repositorios;

import domain.entities.servicios.ServicioPublico;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class ServicioPublicoRepo {
    private List<ServicioPublico> serviciosPublicos;

    public ServicioPublico buscar(String tipoDeTransporte, String linea){

        Optional<ServicioPublico> servicioEncontrado = serviciosPublicos.stream()
                .filter(servicio -> servicio.getTipoDeTransporte()
                        .toString().equals(tipoDeTransporte)
                        && servicio.getLinea().getNombre().equals(linea)).findFirst();
        if (servicioEncontrado.isPresent()){
            return servicioEncontrado.get();
        }else return null;
    }

    public ServicioPublicoRepo() {
        this.serviciosPublicos = new ArrayList<>();
    }

    public void agregarServicio(ServicioPublico servicio) {
        serviciosPublicos.add(servicio);
    }
}
