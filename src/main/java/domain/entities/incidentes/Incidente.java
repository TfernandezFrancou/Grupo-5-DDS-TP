package domain.entities.incidentes;

import domain.entities.actores.miembros.Miembro;

import java.util.Date;
import java.util.List;

public abstract class Incidente {

    //private Establecimiento establecimiento;
    //private Servicio servicio;
    private String descripcion;
    private Boolean resuelto; // TODO: Esto es el estado?
    private Date fechaRealizacion;
    private Date fechaCierre;

    public Incidente(String descripcion, Date fechaRealizacion) {
        this.descripcion = descripcion;
        this.fechaRealizacion = fechaRealizacion;
    }

    public abstract List<Miembro> obtenerContactos();
    public abstract void notificar();
}
