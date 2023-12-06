package dto;

import domain.entities.actores.miembros.MiembroPorComunidad;
import lombok.Getter;

@Getter
public class MiembroPresentacion {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String tipoDeMiembro;
    private Boolean esAdmin;

    public MiembroPresentacion(MiembroPorComunidad miembro){
        this.nombre=miembro.getMiembro().getNombre();
        this.apellido=miembro.getMiembro().getApellido();
        this.email=miembro.getMiembro().getEmail();
        this.telefono=miembro.getMiembro().getTelefono();
        this.tipoDeMiembro=miembro.getTipoDeMiembro().getTipoDeMiembro();
        this.esAdmin=miembro.getEsAdmin();
    }
}
