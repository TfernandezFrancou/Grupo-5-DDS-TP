package scheduler;

import domain.entities.notificaciones.HorarioNotificacion;
import domain.entities.repositorios.HorarioNotificacionRepo;
import lombok.Getter;
import org.quartz.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
public class GeneradorScheduelerNotificacion {
    private List<HorarioNotificacion> horariosNotificacion;
    public void generar() throws SchedulerException {
        HorarioNotificacionRepo.getInstance().getHorarios().forEach(this::agregarHorario);
        comenzar();
    }
    public void agregarHorario(HorarioNotificacion horario){
        horariosNotificacion.add(horario);
    }
    private String armarCron(){
        return "Hola";
    }
    public String armarUnCron(LocalDateTime horario){
        //Devuelve un cron para todos los dias en el horario recibido
        return ""+ horario.getSecond() + " " + horario.getMinute() + " "+horario.getHour() + " * * ? *";

    }
    private void comenzar() throws SchedulerException {
        // Creacion del scheduler
        SchedulerFactory schedFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = schedFactory.getScheduler();

        //Creacion del Trabajo a realizar
        JobBuilder jobBuilder = JobBuilder.newJob(JobNotificar.class);
        JobDetail jobDetail = jobBuilder.withIdentity("JobNotificar").build();

        //Creacion del triger

    }
}
