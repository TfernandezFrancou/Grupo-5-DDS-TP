package domain.entities.sugerencias;


import domain.entities.actores.miembros.Miembro;

import domain.entities.incidentes.IncidenteMiembro;
import domain.entities.repositorios.EstablecimientosRepo;
import domain.entities.repositorios.IncidentesRepo;
import domain.entities.servicios.Establecimiento;

import java.util.ArrayList;
import java.util.List;


public class RevisionDeIncidentes {
    private static RevisionDeIncidentes instance;

    private RevisionDeIncidentes() {

    }
    public static RevisionDeIncidentes getInstance() {
        if(instance==null){
            instance=new RevisionDeIncidentes();
        }
        return instance;
    }
    //todo: usar incidentes y no incidentemiembro maybe
    public List<IncidenteMiembro> obtenerIncidentes(Miembro miembro){
        List<Establecimiento> establecimientos = estaCercaDe(miembro);
        List<IncidenteMiembro>  incidentes = new ArrayList<>();
        if(establecimientos != null) {
            for(Establecimiento establecimiento : establecimientos){
                incidentes.addAll(IncidentesRepo.getInstance().buscarIncidentesPorEstablecimientoResuelto(establecimiento));
            }
        }
        return incidentes;
    }

    private List<Establecimiento> estaCercaDe(Miembro miembro){
        //esto ponele que encuentra los establecimientos
        return EstablecimientosRepo.getInstance().buscarEstablecimientos();
    }

}
