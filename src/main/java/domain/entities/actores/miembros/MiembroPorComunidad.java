package domain.entities.actores.miembros;

import domain.entities.actores.Comunidad;
import domain.entities.actores.miembros.Miembro;
import lombok.Getter;

public class MiembroPorComunidad {

    @Getter
    private Miembro miembro;
    @Getter
    private Comunidad comunidad;
    private TipoDeMiembro tipoDeMiembro;
    private Boolean esAdmin;

    public MiembroPorComunidad(Miembro miembro) {
        this.miembro = miembro;
    }
/* public Boolean esAfectado(){

    }

    */
}
