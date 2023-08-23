package domain;

import domain.entities.ranking.GeneradorDeRankings;
import domain.entities.repositorios.LineaRepo;
import domain.entities.repositorios.OrganizacionesRepo;
import domain.entities.servicios.Linea;
import domain.entities.servicios.Organizacion;
import domain.entities.servicios.TipoDeTransporte;
import org.junit.Before;
import org.junit.Test;

public class RankingTest {
    GeneradorDeRankings rankings = new GeneradorDeRankings();
    @Before
    public void init(){
        //Creo 5 lineas y las agrego al repo
        Linea linea1 = new Linea("7", TipoDeTransporte.COLECTIVO);
        Linea linea2 = new Linea("B",TipoDeTransporte.SUBTE);
        Linea linea3 = new Linea("E",TipoDeTransporte.SUBTE);
        Linea linea4 = new Linea("51",TipoDeTransporte.COLECTIVO);
        Linea linea5 = new Linea("435",TipoDeTransporte.COLECTIVO);

        LineaRepo.getInstance().agregar(linea1);
        LineaRepo.getInstance().agregar(linea2);
        LineaRepo.getInstance().agregar(linea3);
        LineaRepo.getInstance().agregar(linea4);
        LineaRepo.getInstance().agregar(linea5);

        //Creo 3 organizaciones y las agrego al repo
        Organizacion org1 = new Organizacion("Colectivos San Vicente","SA");
        Organizacion org2 = new Organizacion("Transportes Rápido-Express","SRL");
        Organizacion org3 = new Organizacion("Transporte Total","SA");

        OrganizacionesRepo.getInstance().agregar(org1);
        OrganizacionesRepo.getInstance().agregar(org2);
        OrganizacionesRepo.getInstance().agregar(org3);

    }


}
