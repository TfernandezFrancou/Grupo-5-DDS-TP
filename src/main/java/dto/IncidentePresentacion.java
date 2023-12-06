package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.entities.incidentes.Incidente;
import domain.entities.incidentes.IncidenteMiembro;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class IncidentePresentacion {
    private  String creador;
    private String establecimiento;
    private  String servicio;
    private  String estado;
    private  String fechaCreacion;
    private  String descripcion;
    private  String fechaCierre;

    public IncidentePresentacion(Incidente incidente){
        this.creador= incidente.obtenerCreador();
        this.establecimiento= incidente.getEstablecimiento().getNombre();
        this.servicio= incidente.getServicio().obtenerDescripcion();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm - dd/MM/yy");
        if(incidente.getResuelto()){
            this.estado="Resuelto/Cerrado";
            this.fechaCierre=incidente.getFechaCierre().format(formatter);
        }else{
            this.estado="Abierto";
        }
        this.fechaCreacion=incidente.getFechaRealizacion().format(formatter);
        this.descripcion= incidente.getDescripcion();
    }
    @JsonCreator
    public IncidentePresentacion(@JsonProperty("servicio") String servicio,
                                 @JsonProperty("establecimiento") String establecimiento,
                                 @JsonProperty("descripcion") String descripcion,
                                 @JsonProperty("fechaCreacion") String fechaCreacion) {
        this.servicio = servicio;
        this.establecimiento = establecimiento;
        this.descripcion = descripcion;
        this.fechaCreacion= fechaCreacion;
    }
}
