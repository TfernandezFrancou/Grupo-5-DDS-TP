package domain.entities.repositorios;

import domain.entities.ranking.Ranking;
import domain.entities.servicios.Establecimiento;
import lombok.Getter;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
@Getter
public class EstablecimientosRepo {
    private static EstablecimientosRepo instance;
    private List<Establecimiento> estalecimientos;

    private EstablecimientosRepo(){this.estalecimientos=new ArrayList<>();}

    public static EstablecimientosRepo getInstance() {
        if (instance == null) {
            instance = new EstablecimientosRepo();
        }
        return instance;
    }

    public List<Establecimiento> buscarEstablecimientos(){
        EntityManager em = utils.BDUtils.getEntityManager();
        this.estalecimientos = em.createQuery("select e from Establecimiento e", Establecimiento.class).
                getResultList();
        return this.estalecimientos;
    }
}
