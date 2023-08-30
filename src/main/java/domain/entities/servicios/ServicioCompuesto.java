package domain.entities.servicios;

import java.util.List;

public class ServicioCompuesto extends Servicio {

    private AgrupacionServicio agrupacionServicio;
    private List<ServicioBase> servicios;

    public ServicioCompuesto(Establecimiento establecimiento,AgrupacionServicio agrupacionServicio){
        this.establecimiento = establecimiento;
        this.agrupacionServicio =  agrupacionServicio;
    }
}