package domain.entities.ranking.FormasRankings;

import domain.entities.incidentes.Incidente;
import domain.entities.repositorios.IncidentesRepo;
import domain.entities.servicios.Entidad;
import domain.entities.servicios.Servicio;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MayorCantidadIncidentes extends FormaRanking{
    @Override
    public void generar() {
        List<Incidente> listaIncidentes = IncidentesRepo.getInstance().buscarIncidentesSemana(LocalDateTime.now());

        int horasRango = 24;

        // Agrupar los incidentes por entidad y servicio asociado
        Map<Entidad, Map<Servicio, List<Incidente>>> incidentesPorEntidadYServicio = listaIncidentes.stream()
                .filter(incidente -> incidente.getResuelto().equals(false)) // Filtrar solo los incidentes abiertos
                .collect(Collectors.groupingBy(incidente -> incidente.getEstablecimiento().getEntidad(),
                        Collectors.groupingBy(Incidente::getServicio)));

        // Obtener la cantidad de incidentes por entidad, sin contar los servicios duplicados en un rango de 24 horas
        Map<Entidad, Integer> rankingEntidades = new HashMap<>();
        for (Map.Entry<Entidad, Map<Servicio, List<Incidente>>> entidadEntry : incidentesPorEntidadYServicio.entrySet()) {
            int incidentesContados = 0;
            for (List<Incidente> incidentes : entidadEntry.getValue().values()) {
                if (!incidentes.isEmpty()) {
                    incidentesContados++;
                    Incidente ultimoIncidente = incidentes.get(incidentes.size() - 1);
                    for (int i = incidentes.size() - 2; i >= 0; i--) {
                        if (ultimoIncidente.esRepetidoEnRango(incidentes.get(i), horasRango)) {
                            break;
                        }
                        incidentesContados++;
                        ultimoIncidente = incidentes.get(i);
                    }
                }
            }
            rankingEntidades.put(entidadEntry.getKey(), incidentesContados);
        }

        // Ordenar las entidades según la cantidad de incidentes
        List<Entidad> entidadesOrdenadas = rankingEntidades.entrySet().stream()
                .sorted(Map.Entry.<Entidad, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
