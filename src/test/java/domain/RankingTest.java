package domain;

import domain.entities.ranking.GeneradorDeRankings;
import domain.entities.repositorios.LineaRepo;
import domain.entities.servicios.Linea;
import domain.entities.servicios.TipoDeTransporte;
import org.junit.Before;
import org.junit.Test;

public class RankingTest {
    GeneradorDeRankings rankings = new GeneradorDeRankings();
    @Before
    public void init{
        Linea linea1 = new Linea("7", TipoDeTransporte.COLECTIVO);
        Linea linea2 = new Linea("A",TipoDeTransporte.SUBTE);

        LineaRepo.getInstance().agregar(linea1);
        LineaRepo.getInstance().agregar(linea2);
    }
    @Test

}
