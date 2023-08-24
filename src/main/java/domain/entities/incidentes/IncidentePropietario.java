package domain.entities.incidentes;

import domain.entities.actores.Propietario;
import domain.entities.actores.miembros.Miembro;
import domain.entities.servicios.Establecimiento;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class IncidentePropietario extends Incidente {

    private Propietario propietario;

    public IncidentePropietario(String descripcion, LocalDateTime fechaRealizacion, Establecimiento establecimiento) {
        super(descripcion, fechaRealizacion, establecimiento);
    }


    @Override
    public List<Miembro> obtenerContactos() {
        return null;
    }

    @Override
    public void notificar() {

    }
}
