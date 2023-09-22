package domain.entities.notificaciones;


import domain.entities.actores.miembros.Miembro;
import domain.entities.incidentes.Incidente;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Notificacion {
    private Incidente incidente;
    private List<Miembro> miembros;

    public Notificacion(){

    }

    public void notificar(LocalDateTime hora){
        List<Miembro> miembrosANotificar = miembros.stream().filter(m -> m.tieneRangoHorario(hora)).collect(Collectors.toList());

        miembrosANotificar.forEach(m->m.notificar(this));
        miembros.removeAll(miembrosANotificar);
    }

    public Boolean estaVacia(){
        return this.miembros.isEmpty();
    }
}
