package scheduler;

import domain.entities.notificaciones.HorarioNotificacion;
import domain.entities.repositorios.HorarioNotificacionRepo;
import lombok.Getter;
import org.quartz.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GeneradorScheduelerNotificacion {
    private List<Integer> minutosNotificacion;
    public GeneradorScheduelerNotificacion(){
        this.minutosNotificacion=new ArrayList<>();
        HorarioNotificacionRepo.getInstance().getHorarios().forEach(this::obtenerMinuto);
    }
    public void obtenerMinuto(HorarioNotificacion horario){

        if(minutosNotificacion.contains(horario.getHorario().getMinute())){
            return;
        }
        minutosNotificacion.add(horario.getHorario().getMinute());
    }
    public String armarCron(){
        String minutos = minutosNotificacion.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        return "0 " + minutos + " * 1/1 * ? *";
    }

    private void comenzar() throws SchedulerException {
        // Creacion del scheduler
        SchedulerFactory schedFactory = new org.quartz.impl.StdSchedulerFactory();
        Scheduler scheduler = schedFactory.getScheduler();

        //Creacion del Trabajo a realizar
        JobBuilder jobBuilder = JobBuilder.newJob(JobNotificar.class);
        JobDetail jobDetail = jobBuilder.withIdentity("JobNotificar").build();

        //Creacion del triger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("TemporizadorNotificaciones")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(armarCron()))
                .build();

        //Asigno el trabajo y el trigger al schedueler
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

    }
}
