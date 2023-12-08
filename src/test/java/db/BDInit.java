package db;

import domain.entities.actores.Comunidad;
import domain.entities.actores.Rol;
import domain.entities.actores.Usuario;
import domain.entities.actores.miembros.Miembro;
import domain.entities.actores.miembros.MiembroPorComunidad;
import domain.entities.actores.miembros.TipoDeMiembro;
import domain.entities.incidentes.Incidente;
import domain.entities.incidentes.IncidenteMiembro;
import domain.entities.ranking.GeneradorDeRankings;
import domain.entities.repositorios.IncidentesRepo;
import domain.entities.repositorios.RankingsRepo;
import domain.entities.repositorios.TipoDeServicioRepo;
import domain.entities.servicios.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.BDUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

public class BDInit {
    Linea linea1;
    Linea linea2;
    Establecimiento paradaMedrano;
    Establecimiento paradaCarlos;
    Establecimiento paradaPlata;
    Establecimiento paradaJujuy;
    ServicioBase banioHMedrano;
    ServicioBase banioMCarlos;
    ServicioBase escaleraPlata;
    ServicioBase banioJujuy;
    MiembroPorComunidad juanDeViajeros;
    Miembro juan;
    Comunidad viajeros;
    AgrupacionServicio banio;
    AgrupacionServicio escalera;
    TipoDeServicio banioHombres;
    TipoDeServicio banioMujeres;
    TipoDeServicio acceso;
    TipoDeEstablecimiento tipoA;
    TipoDeMiembro observador;
    TipoDeMiembro noObservador;
    Incidente incidente1;
    Incidente incidente2;
    Incidente incidente3;
    Usuario usuario1;

    @Before
    public void init(){
         usuario1 = new Usuario("juan","123", Rol.MIEMBRO);
        //Creo 2 lineas y las agrego al repo
        linea1 = new Linea("Linea B", TipoDeTransporte.SUBTE);
        linea2 = new Linea("Linea E",TipoDeTransporte.SUBTE);

        //Creo 1 tipos de establecimieto
         tipoA = new TipoDeEstablecimiento("Estacion");

        //Creo 4 Establecimientos
        paradaMedrano = new Establecimiento("Medrano",tipoA,linea1);
        paradaCarlos = new Establecimiento("Carlosgardel",tipoA,linea1);
        paradaPlata = new Establecimiento("AvLa plata",tipoA,linea2);
        paradaJujuy = new Establecimiento("Jujuy",tipoA,linea2);

        //Agrego los establecimietos a la entidad correspondiente
        linea1.agregarSucursal(paradaMedrano);
        linea1.agregarSucursal(paradaCarlos);
        linea2.agregarSucursal(paradaPlata);
        linea2.agregarSucursal(paradaJujuy);

        //Creo 2 agrupaciones de servicio
         banio = new AgrupacionServicio("Baño");
         escalera = new AgrupacionServicio("Escalera");

        //Creo 3 tipos de servicio
         banioHombres = new TipoDeServicio("Hombre",banio);
         banioMujeres = new TipoDeServicio("Mujer",banio);
         acceso = new TipoDeServicio("Acceso",escalera);

        //Creo 4 servicios
        banioHMedrano = new ServicioBase(paradaMedrano,Boolean.TRUE,banioHombres);
        banioMCarlos = new ServicioBase(paradaCarlos,Boolean.TRUE,banioMujeres);
        escaleraPlata = new ServicioBase(paradaPlata, Boolean.TRUE,acceso);
        banioJujuy = new ServicioBase(paradaJujuy,Boolean.TRUE,banioMujeres);

        //Agrego los servicios a los establecimientos correspondientes
        paradaMedrano.agregarServicio(banioHMedrano);
        paradaCarlos.agregarServicio(banioMCarlos);
        paradaPlata.agregarServicio(escaleraPlata);
        paradaJujuy.agregarServicio(banioJujuy);

        //Creo un miembro por comunidad
        viajeros = new Comunidad("Viajeros","Reportar incidentes del subte");
        juan = new Miembro("Juan Francisco","Caceres","jucaceres@frba.utn.edu.ar","11123");
        juanDeViajeros = new MiembroPorComunidad(juan,viajeros);

        //creo incidentes
        incidente1 = new IncidenteMiembro("Incidente en EscaleraPlata 1", escaleraPlata, LocalDateTime.of(2023, 8, 21, 10, 0), paradaPlata, juanDeViajeros);
        incidente2 = new IncidenteMiembro("Incidente en Medrano", banioHMedrano, LocalDateTime.of(2023, 8, 21, 0, 0), paradaMedrano, juanDeViajeros);
        incidente3 = new IncidenteMiembro("Incidente en Carlos", banioMCarlos, LocalDateTime.of(2023, 8, 21, 0, 0), paradaCarlos, juanDeViajeros);
        incidente1.cerrarIncidente(LocalDateTime.of(2023, 8, 21, 2, 0));

        //Creo los dos tipos de miembros
        observador= new TipoDeMiembro("Observador");
        noObservador= new TipoDeMiembro("Usuarios de servicio");

        juan.setUsuario(usuario1);
        juanDeViajeros.setTipoDeMiembro(noObservador);
    }
    @Test
    public void persistir(){
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);
        em.persist(usuario1);
        em.persist(observador);
        em.persist(noObservador);
        em.persist(tipoA);
        em.persist(linea1);
        em.persist(linea2);
        em.persist(paradaMedrano);
        em.persist(paradaCarlos);
        em.persist(paradaPlata);
        em.persist(paradaJujuy);
        em.persist(banio);
        em.persist(escalera);
        em.persist(banioHombres);
        em.persist(banioMujeres);
        em.persist(banioHMedrano);
        em.persist(banioMCarlos);
        em.persist(escaleraPlata);
        em.persist(banioJujuy);
        em.persist(viajeros);
        em.persist(juan);
        em.persist(juanDeViajeros);
        em.persist(incidente1);
        em.persist(incidente2);
        em.persist(incidente3);

        BDUtils.commit(em);
    }
    /*@Test
    public void buscarTipoServicioTest(){
        banioHombres = TipoDeServicioRepo.getInstance().buscar("Baño","Hombre");

        Assert.assertEquals("Hombre",banioHombres.getTipoDeServicio());
    }*/
}
