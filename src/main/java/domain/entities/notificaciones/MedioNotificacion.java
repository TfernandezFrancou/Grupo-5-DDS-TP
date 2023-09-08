package domain.entities.notificaciones;

import javax.persistence.*;

@Entity
@Table
public class MedioNotificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medio_notificacion_codigo;

    @Column
    private String medioNotificacion;
}
