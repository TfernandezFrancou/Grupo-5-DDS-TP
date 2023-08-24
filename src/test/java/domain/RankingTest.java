package domain;

import domain.entities.incidentes.Incidente;
import domain.entities.incidentes.IncidenteMiembro;
import domain.entities.ranking.FormasRankings.FormaRanking;
import domain.entities.ranking.GeneradorDeRankings;
import domain.entities.repositorios.LineaRepo;
import domain.entities.repositorios.OrganizacionesRepo;
import domain.entities.servicios.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class RankingTest {
    GeneradorDeRankings rankings = new GeneradorDeRankings();
    @Before
    public void init(){
        //Creo 5 lineas y las agrego al repo
        Linea linea1 = new Linea("Linea B",TipoDeTransporte.SUBTE);
        Linea linea2 = new Linea("Linea E",TipoDeTransporte.SUBTE);
        //El repo no se usa en los metodos, al menos el de lineas pero lo dejo por si en el futuro si
        //LineaRepo.getInstance().agregar(linea1);

        //Creo 1 tipos de establecimieto
        TipoDeEstablecimiento tipoA = new TipoDeEstablecimiento("Estacion");

        //Creo 4 Establecimientos
        Establecimiento paradaMedrano = new Establecimiento("Medrano",tipoA);
        Establecimiento paradaCarlos = new Establecimiento("Carlosgardel",tipoA);
        Establecimiento paradaPlata = new Establecimiento("AvLa plata",tipoA);
        Establecimiento paradaJujuy = new Establecimiento("Jujuy",tipoA);

        //Agrego los establecimietos a la entidad correspondiente
        linea1.agregarSucursal(paradaMedrano);
        linea1.agregarSucursal(paradaCarlos);
        linea2.agregarSucursal(paradaPlata);
        linea2.agregarSucursal(paradaJujuy);

        //Creo 2 agrupaciones de servicio
        AgrupacionServicio banio = new AgrupacionServicio("Baño");
        AgrupacionServicio escalera = new AgrupacionServicio("Escalera");

        //Creo 3 tipos de servicio
        TipoDeServicio banioHombres = new TipoDeServicio("Hombre",banio);
        TipoDeServicio banioMujeres = new TipoDeServicio("Mujer",banio);
        TipoDeServicio acceso = new TipoDeServicio("Acceso",escalera);

        //Creo 4 servicios
        ServicioBase banioHMedrano = new ServicioBase(paradaMedrano,Boolean.TRUE,banioHombres);
        ServicioBase banioMCarlos = new ServicioBase(paradaCarlos,Boolean.TRUE,banioMujeres);
        ServicioBase escaleraPlata = new ServicioBase(paradaPlata, Boolean.TRUE,acceso);
        ServicioBase banioJujuy = new ServicioBase(paradaJujuy,Boolean.TRUE,banioMujeres);


        // seteo la fecha del ranking
        rankings.setFechaRealizacion(LocalDateTime.of(2023,6,27,12,00));

    }


}
