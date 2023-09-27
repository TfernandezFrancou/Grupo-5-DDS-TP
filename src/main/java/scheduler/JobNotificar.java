package scheduler;

import domain.entities.notificaciones.NotificadorIncidentes;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobNotificar implements Job {

    NotificadorIncidentes notificadorIncidentes;
    @Override
    public void execute(JobExecutionContext jobContext) {

        /*
        notificacionesPendientes ---> viene del resultado de un slect en la base de datos
        if(notificacionesPendientes.isEmpty()){thorw throw new JobExecutionException("No hay notificaciones Pendientes");}
        noitifacdorIncidente.agregarNotificaciones(notificacionesPendientes)
         */
        notificadorIncidentes.notificar();
    }
}
