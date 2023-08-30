package domain.entities.ranking.FormasRankings;

import domain.entities.incidentes.Incidente;
import domain.entities.ranking.Ranking;
import domain.entities.ranking.TipoRanking;
import domain.entities.repositorios.IncidentesRepo;
import domain.entities.repositorios.RankingsRepo;
import domain.entities.servicios.Entidad;
import domain.entities.servicios.Rankeable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MayorTiempoPromedio extends FormaRanking{
    @Override
    public void generar(LocalDateTime fecha){
        List<Incidente> listaIncidentes = IncidentesRepo.getInstance().buscarIncidentesResueltosSemana(fecha);

        Map<Entidad, List<Incidente>> incidentesPorEntidad = listaIncidentes.stream()
                .collect(Collectors.groupingBy(incidente -> incidente.getEstablecimiento().getEntidad()));


        Map<Entidad, Double> tiempoPromedioPorEntidad = incidentesPorEntidad.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .mapToLong(incidente -> Duration.between(incidente.getFechaRealizacion(), incidente.getFechaCierre()).toDays())
                                .average()
                                .orElse(0)
                ));

        // Ordenar las entidades según su tiempo de cierre promedio
        List<Rankeable> entidadesOrdenadas = tiempoPromedioPorEntidad.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        Ranking ranking = new Ranking(entidadesOrdenadas,new TipoRanking("Mayor Tiempo Promedio"), fecha);
        RankingsRepo.getInstance().agregarRanking(ranking);

    }
}
