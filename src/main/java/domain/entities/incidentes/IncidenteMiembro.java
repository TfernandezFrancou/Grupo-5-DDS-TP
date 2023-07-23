package domain.entities.incidentes;

import domain.entities.actores.miembros.Miembro;
import domain.entities.actores.miembros.MiembroPorComunidad;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class IncidenteMiembro extends Incidente{

    private MiembroPorComunidad miembro;

    public IncidenteMiembro(String descripcion, LocalDateTime fechaRealizacion) {
        super(descripcion, fechaRealizacion);
    }

    @Override
    public List<Miembro> obtenerContactos() {
        return null;
    }

    @Override
    public void notificar() {

    }
}
