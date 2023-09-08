package domain.entities.actores.miembros;

import domain.entities.actores.Usuario;
import domain.entities.notificaciones.MedioNotificacion;
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

    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_codigo", referencedColumnName = "usuario_codigo")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Entidad> entidadesDeInteres;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "localizacion_codigo", referencedColumnName = "localizacion_codigo")
    private Localizacion localizacion;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "medio_notificacion_codigo", referencedColumnName = "medio_notificacion_codigo")
    private MedioNotificacion medioNotificacion;


    public Miembro(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public Miembro() {

    }
}
