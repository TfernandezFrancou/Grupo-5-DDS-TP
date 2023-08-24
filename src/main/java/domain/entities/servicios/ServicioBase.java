package domain.entities.servicios;

public class ServicioBase extends Servicio{

    private Boolean estaHabilitado;
    private TipoDeServicio tipoDeServicio;

    public ServicioBase(Establecimiento establecimiento,Boolean x, TipoDeServicio tipoDeServicio){
        this.establecimiento = establecimiento;
        this.estaHabilitado= x;
        this.tipoDeServicio =tipoDeServicio;
    }

}
