package domain.entities.incidentes;

import domain.entities.actores.miembros.Miembro;
import domain.entities.actores.miembros.MiembroPorComunidad;
import domain.entities.servicios.Establecimiento;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class IncidenteMiembro extends Incidente{

    private MiembroPorComunidad miembro;

    public IncidenteMiembro(String descripcion, LocalDateTime fechaRealizacion, Establecimiento establecimiento) {
        super(descripcion, fechaRealizacion,establecimiento);
    }

    @Override
    public List<Miembro> obtenerContactos() {
        return null;
    }

    @Override
    public void notificar() {

    }
}
