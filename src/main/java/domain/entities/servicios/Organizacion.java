package domain.entities.servicios;

public class Organizacion extends Entidad {
    private String tipoOrg;

    public Organizacion(String nombre,String tipoOrg) {
        this.nombre = nombre;
        this.tipoOrg = tipoOrg;
    }
}
