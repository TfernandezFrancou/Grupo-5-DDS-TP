package domain.entities.repositorios;

import domain.entities.servicios.ServicioPublico;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class ServicioPublicoRepo {
    private List<ServicioPublico> serviciosPublicos;

    private static ServicioPublicoRepo instance;

    private ServicioPublicoRepo() {
        this.serviciosPublicos = new ArrayList<>();
    }

    public static ServicioPublicoRepo getInstance() {
        if (instance == null) {
            instance = new ServicioPublicoRepo();
        }
        return instance;
    }

    public ServicioPublico buscar(String tipoDeTransporte){

        Optional<ServicioPublico> servicioEncontrado = serviciosPublicos.stream()
                .filter(servicio -> servicio.getTipoDeTransporte()
                        .toString().equals(tipoDeTransporte)).findFirst();
        if (servicioEncontrado.isPresent()){
            return servicioEncontrado.get();
        }else return null;
    }


    public void agregarServicio(ServicioPublico servicio) {
        serviciosPublicos.add(servicio);
    }
}
