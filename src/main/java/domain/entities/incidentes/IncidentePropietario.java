package domain.entities.incidentes;

import domain.entities.actores.Propietario;
import domain.entities.actores.miembros.Miembro;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class IncidentePropietario extends Incidente {

    private Propietario propietario;

    public IncidentePropietario(String descripcion, LocalDateTime fechaRealizacion) {
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
