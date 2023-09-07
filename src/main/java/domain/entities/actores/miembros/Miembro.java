package domain.entities.actores.miembros;

import domain.entities.actores.Usuario;
import domain.entities.services.georef.entities.Localizacion;
import domain.entities.servicios.Entidad;
import lombok.Getter;

import javax.persistence.*;
import javax.transaction.TransactionScoped;
import java.util.List;
@Entity
@Table(name = "Miembros")
@Getter
public class Miembro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int miembro_codigo;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;

    @Column
    private String telefono;

    @OneToMany(mappedBy = "miembro", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<MiembroPorComunidad> comunidades;

    @Transient
    private Usuario usuario;

    @Transient
    private List<Entidad> entidadesDeInteres;

    @Transient
    private Localizacion localizacion;
    //private MedioNotificacion medioNotificacion


    public Miembro(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public Miembro() {

    }
}
