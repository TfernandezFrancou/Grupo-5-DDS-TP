package domain.entities.incidentes;

import domain.entities.actores.miembros.Miembro;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public abstract class Incidente {

    //private Establecimiento establecimiento;
    //private Servicio servicio;
    private String descripcion;
    private Boolean resuelto; // TODO: Esto es el estado?
    private LocalDateTime fechaRealizacion;
    private LocalDateTime fechaCierre;

    public Incidente(String descripcion, LocalDateTime fechaRealizacion) {
        this.descripcion = descripcion;
        this.fechaRealizacion = fechaRealizacion;
    }

    public abstract List<Miembro> obtenerContactos();
    public abstract void notificar();
}
