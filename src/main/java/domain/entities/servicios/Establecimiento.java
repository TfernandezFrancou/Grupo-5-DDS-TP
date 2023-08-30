package domain.entities.servicios;

import domain.entities.services.georef.entities.Localizacion;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {
    private String nombre;
    private List<Servicio> servicios;
    private TipoDeEstablecimiento tipoDeEstablecimiento;
    private Localizacion localizacion;
    @Getter
    private Entidad entidad;

    public Establecimiento(String nombre, TipoDeEstablecimiento tipoDeEstablecimiento, Entidad entidad){
        this.servicios = new ArrayList<>();
        this.nombre = nombre;
        this.tipoDeEstablecimiento= tipoDeEstablecimiento;
        this.entidad = entidad;
    }
    public void agregarServicio(Servicio servicio){
        this.servicios.add(servicio);
    }
}
