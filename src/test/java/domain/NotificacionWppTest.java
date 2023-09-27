package domain;

import domain.entities.actores.miembros.Miembro;
import domain.entities.actores.miembros.MiembroPorComunidad;
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

public class NotificacionWppTest {

    Miembro miembro1;
    EstrategiaWhatsapp wpp;
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
                "ignacio.bisio8780@gmail.com",
                "+5491131772043");

        incidente = new IncidenteMiembro("Los baños de la linea A no funcionan",
                servicio,fecha,establecimiento,miembroPorComunidad);

        notificacion = new Notificacion(incidente,miembros);
        wpp = new EstrategiaWhatsapp();
    }

    @Test
    public void NotificarPorWpp(){

        wpp.notificar(notificacion,miembro1);

    }
}
