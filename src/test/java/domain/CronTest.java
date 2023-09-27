package domain;

import domain.entities.notificaciones.HorarioNotificacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scheduler.GeneradorScheduelerNotificacion;

import java.time.LocalDateTime;

public class CronTest {
    GeneradorScheduelerNotificacion generador;
    HorarioNotificacion h1;
    HorarioNotificacion h2;
    HorarioNotificacion h3;
    @Before
    public void init(){
        this.generador = new GeneradorScheduelerNotificacion();
        h1 = new HorarioNotificacion(LocalDateTime.of(2023, 8, 21, 15, 0));
        h2= new HorarioNotificacion(LocalDateTime.of(2023, 8, 21, 15, 15));
        h3= new HorarioNotificacion(LocalDateTime.of(2023, 8, 21, 15, 30));

        generador.obtenerMinuto(h1);
        generador.obtenerMinuto(h2);
        generador.obtenerMinuto(h2);//Lo pongo duplicado pero no deberia aparecer duplicado
        generador.obtenerMinuto(h3);

    }
    @Test
    public void armadoDeCron(){

        String cron =generador.armarCron();

        Assert.assertEquals("0 0,15,30 * 1/1 * ? *",cron);

    }
}
