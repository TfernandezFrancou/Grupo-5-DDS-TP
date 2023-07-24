package domain.entities.servicios;

public class ServicioBase extends Servicio{

    private Boolean estaHabilitado;
    private TipoDeServicio tipoDeServicio;

    ServicioBase(Boolean x, TipoDeServicio tipoDeServicio){
        this.estaHabilitado= x;
        this.tipoDeServicio =tipoDeServicio;
    }

}
