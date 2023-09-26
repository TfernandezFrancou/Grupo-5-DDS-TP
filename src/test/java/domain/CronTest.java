package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scheduler.GeneradorScheduelerNotificacion;

import java.time.LocalDateTime;

public class CronTest {
    GeneradorScheduelerNotificacion generador;
    @Before
    public void init(){
        this.generador = new GeneradorScheduelerNotificacion();
    }
    @Test
    public void armadoDeCron(){
        String cron =generador.armarUnCron(LocalDateTime.of(2023, 8, 21, 15, 0));

        Assert.assertEquals("0 0 15 * * ? *",cron);

    }
}
