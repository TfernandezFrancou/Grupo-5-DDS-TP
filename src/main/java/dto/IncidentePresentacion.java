package dto;

import domain.entities.incidentes.IncidenteMiembro;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

@Getter
public class IncidentePresentacion {
    private String establecimiento;
    private  String servicio;
    private  String estado;
    private  String fechaCreacion;

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
}
