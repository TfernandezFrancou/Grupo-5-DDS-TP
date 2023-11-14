package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.entities.incidentes.IncidenteMiembro;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class IncidentePresentacion {
    private String establecimiento;
    private  String servicio;
    private  String estado;
    private  String fechaCreacion;
    private  String descripcion;

    public IncidentePresentacion(IncidenteMiembro incidente){
        this.establecimiento= incidente.getEstablecimiento().getNombre();
        this.servicio= "Banio/hardcore";

        if(incidente.getResuelto()){
            this.estado="Resuelto/Cerrado";
        }else{
            this.estado="Abierto";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        this.fechaCreacion=incidente.getFechaRealizacion().format(formatter);
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
