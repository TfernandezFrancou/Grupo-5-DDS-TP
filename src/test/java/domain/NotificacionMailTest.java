package domain;

import domain.entities.actores.miembros.Miembro;
import domain.entities.notificaciones.EstrategiaEmail;
import domain.entities.notificaciones.EstrategiaWhatsapp;
import domain.entities.notificaciones.Notificacion;
import org.junit.Before;
import org.junit.Test;

public class NotificacionMailTest {

    Miembro miembro1;
    EstrategiaEmail email;
    Notificacion notificacion;


    @Before
    public void init(){
        miembro1 = new Miembro("Ignacio",
                "Bisio",
                "dominomas2000@gmail.com",
                "+5491165334565");

        notificacion = new Notificacion();
        email = new EstrategiaEmail();
    }

    @Test
    public void NotificarPorEmial(){

        email.notificar(notificacion,miembro1);

    }
}
