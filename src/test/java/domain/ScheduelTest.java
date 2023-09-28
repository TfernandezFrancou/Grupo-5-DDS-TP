package domain;

import domain.entities.notificaciones.HorarioNotificacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.quartz.Scheduler;
import scheduler.GeneradorSchedulerNotificacion;

import java.time.LocalDateTime;

public class ScheduelTest {
    private GeneradorSchedulerNotificacion generador;

    @Before
    public void init(){
        generador = new GeneradorSchedulerNotificacion();

    }
    @Test
    public void testGeneradorSchedulerNotificacion() throws Exception {
        // Configurar un horario de notificación en 1 minuto
        HorarioNotificacion horario = new HorarioNotificacion(LocalDateTime.now().plusMinutes(1));
        generador.obtenerHorario(horario);

        // Iniciar el generador y el scheduler simulado
        generador.comenzar();

        // Esperar un tiempo suficiente para que el trabajo se ejecute (aquí estamos esperando 2 minutos)
        Thread.sleep(120000); // 2 minutos en milisegundos

    }
}

