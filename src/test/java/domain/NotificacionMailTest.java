package domain;

import domain.entities.actores.miembros.Miembro;
import domain.entities.actores.miembros.MiembroPorComunidad;
import domain.entities.incidentes.Incidente;
import domain.entities.incidentes.IncidenteMiembro;
import domain.entities.notificaciones.EstrategiaEmail;
import domain.entities.notificaciones.EstrategiaWhatsapp;
import domain.entities.notificaciones.Notificacion;
import domain.entities.servicios.Establecimiento;
import domain.entities.servicios.Servicio;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

public class NotificacionMailTest {

    Miembro miembro1;
    EstrategiaEmail email;
    Notificacion notificacion;
    IncidenteMiembro incidente;
    Servicio servicio;
    LocalDateTime fecha = LocalDateTime.of(2023, 9, 27, 15, 00);
    Establecimiento establecimiento;

    MiembroPorComunidad miembroPorComunidad;

    List<Miembro> miembros;

    @Before
    public void init(){
        miembro1 = new Miembro("Ignacio",
                "Bisio",
                "dominomas2000@gmail.com",
                "+5491165334565");

        incidente = new IncidenteMiembro("Los baños de la linea A no funcionan",
                                        servicio,fecha,establecimiento,miembroPorComunidad);
        notificacion = new Notificacion(incidente);

        email = new EstrategiaEmail();
    }

    @Test
    public void NotificarPorEmial(){

        email.notificar(notificacion,miembro1);

    }
}
