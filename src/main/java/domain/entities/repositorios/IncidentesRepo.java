package domain.entities.repositorios;

import domain.entities.actores.miembros.MiembroPorComunidad;
import domain.entities.incidentes.Incidente;
import domain.entities.incidentes.IncidenteMiembro;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class IncidentesRepo {
    private static IncidentesRepo instance;
    private List<Incidente> incidentes;


    private IncidentesRepo() {
        this.incidentes = new ArrayList<>();
    }

        public static IncidentesRepo getInstance () {
        if (instance == null) {
            instance = new IncidentesRepo();
        }
        return instance;
    }

    public void agregarIncidente(Incidente incidente){this.incidentes.add(incidente);}

    public List<Incidente> buscarIncidentesResueltosSemana(LocalDateTime finSemana){
        LocalDateTime inicioSemana = finSemana.minusWeeks(1);
        return this.incidentes.stream().filter(
                incidente -> incidente.getResuelto().equals(true) &&
                        incidente.getFechaCierre().isBefore(finSemana) &&
                        incidente.getFechaCierre().isAfter(inicioSemana)).collect(Collectors.toList());

    }

    public List<Incidente> buscarIncidentesSemana(LocalDateTime finSemana){
        LocalDateTime inicioSemana = finSemana.minusWeeks(1);
        return this.incidentes.stream().filter(
                incidente ->
                        incidente.getFechaRealizacion().isBefore(finSemana) &&
                        incidente.getFechaRealizacion().isAfter(inicioSemana)).collect(Collectors.toList());
    }
    public List<IncidenteMiembro> buscarIncidentes() {
        EntityManager em = utils.BDUtils.getEntityManager();
        return em.createQuery("select i from IncidenteMiembro i ", IncidenteMiembro.class).getResultList();
    }
    public IncidenteMiembro buscarIncidente(Integer idIncidente) {
        EntityManager em = utils.BDUtils.getEntityManager();
        List<IncidenteMiembro> incidentes = em.createQuery("select i from IncidenteMiembro i WHERE i.id=?1", IncidenteMiembro.class)
                .setParameter(1,idIncidente).getResultList();
        if (incidentes.isEmpty()){return null;}
        return incidentes.get(0);
    }
}
