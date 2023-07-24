package domain.entities.actores.miembros;

import domain.entities.actores.Usuario;
import domain.entities.services.georef.entities.Localizacion;
import domain.entities.servicios.Entidad;

import java.util.List;

public class Miembro {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private List<MiembroPorComunidad> comunidades;
    private Usuario usuario;
    private List<Entidad> entidadesDeInteres;
    private Localizacion localizacion;
    //private MedioNotificacion medioNotificacion


    public Miembro(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
}
