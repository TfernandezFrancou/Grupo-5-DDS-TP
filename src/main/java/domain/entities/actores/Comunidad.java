package domain.entities.actores;

import domain.entities.actores.miembros.MiembroPorComunidad;
import domain.entities.incidentes.Incidente;
import lombok.Getter;

import java.util.List;

public class Comunidad {

    @Getter
    private List<MiembroPorComunidad> miembros;
    private String objetivo;
    private List<Incidente> incidentes;


}
