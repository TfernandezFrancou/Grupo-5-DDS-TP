package domain;

import domain.entities.actores.miembros.Miembro;
import domain.entities.notificaciones.EstrategiaWhatsapp;
import domain.entities.notificaciones.Notificacion;
import org.junit.Before;
import org.junit.Test;

public class NotificacionWppTest {

    Miembro miembro1;
    EstrategiaWhatsapp wpp;
    Notificacion notificacion;


    @Before
    public void init(){
        miembro1 = new Miembro("Ignacio",
                "Bisio",
                "ignacio.bisio8780@gmail.com",
                "+5491131772043");

        notificacion = new Notificacion();
        wpp = new EstrategiaWhatsapp();
    }

    @Test
    public void NotificarPorWpp(){

        wpp.notificar(notificacion,miembro1);

    }
}
