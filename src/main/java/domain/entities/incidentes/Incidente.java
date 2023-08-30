package domain.entities.incidentes;

import domain.entities.actores.miembros.Miembro;
import domain.entities.servicios.Establecimiento;
import domain.entities.servicios.Servicio;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
@Getter
public abstract class Incidente {

    private Establecimiento establecimiento;
    private Servicio servicio;
    private String descripcion;
    private Boolean resuelto; // TODO: Esto es el estado?
    private LocalDateTime fechaRealizacion;
    private LocalDateTime fechaCierre;

    public Incidente(String descripcion,Servicio servicio, LocalDateTime fechaRealizacion,Establecimiento establecimiento) {
        this.descripcion = descripcion;
        this.servicio = servicio;
        this.fechaRealizacion = fechaRealizacion;
        this.establecimiento = establecimiento;
        this.resuelto=Boolean.FALSE;
    }
    public boolean esRepetidoEnRango(Incidente otroIncidente, int horasRango) {
        long horasEntreIncidentes = Math.abs(ChronoUnit.HOURS.between(this.getFechaRealizacion(), otroIncidente.getFechaRealizacion()));

        return this.getServicio().equals(otroIncidente.getServicio()) && horasEntreIncidentes <= horasRango;
    }
    public void cerrarIncidente(LocalDateTime fechaCierre){
        this.fechaCierre=fechaCierre;

    }
    public abstract List<Miembro> obtenerContactos();
    public abstract void notificar();
}
