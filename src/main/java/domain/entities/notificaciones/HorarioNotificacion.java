package domain.entities.notificaciones;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HorarioNotificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int horario_codigo;
    @Column
    private LocalDateTime horario;
}
