package db;

import domain.entities.actores.Comunidad;
import domain.entities.actores.Rol;
import domain.entities.actores.Usuario;
import domain.entities.actores.miembros.Miembro;
import domain.entities.actores.miembros.MiembroPorComunidad;
import domain.entities.actores.miembros.TipoDeMiembro;
import domain.entities.incidentes.Incidente;
import domain.entities.incidentes.IncidenteMiembro;
import domain.entities.servicios.*;
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
    MiembroPorComunidad maxiDeViajeros;
    MiembroPorComunidad tomDeViajeros;
    MiembroPorComunidad ignacioDeViajeros;
    MiembroPorComunidad juan2DeViajeros;
    Miembro juan;
    Miembro maxi;
    Miembro admin;

    Miembro ignacio;

    Miembro juan2;

    Miembro tom;
    Comunidad viajeros;
    AgrupacionServicio banio;
    AgrupacionServicio escalera;
    TipoDeServicio banioHombres;
    TipoDeServicio banioMujeres;
    TipoDeServicio acceso;
    TipoDeEstablecimiento tipoA;
    TipoDeMiembro observador;
    TipoDeMiembro noObservador;
    IncidenteMiembro incidente1;
    Incidente incidente2;
    Incidente incidente3;
    Usuario usuario1;
    Usuario usuario2;
    Usuario usuario3;
    Usuario usuario4;

    Usuario usuario5;
    Usuario usuario6;

    @Before
    public void init(){
         usuario1 = new Usuario("juan","123", Rol.MIEMBRO);
         usuario2 = new Usuario("maxi", "123", Rol.MIEMBRO);
         usuario4 = new Usuario("tom","123", Rol.MIEMBRO);
         usuario3 = new Usuario("admin","123", Rol.ADMIN);
         usuario5 = new Usuario("ignacio","123",Rol.MIEMBRO);
         usuario6 = new Usuario("juan2","123",Rol.MIEMBRO);

         admin=new Miembro("Admin","Admin","admin@gmail.com","749");
         admin.setUsuario(usuario3);

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
        maxi= new Miembro("Maximiliano","Fiorentino","ada@gmail.com","216464");
        tom= new Miembro("Tomás","Fernández Francou","tfernndezfrancou@frba.utn.edu.ar","+54 9 3446 57-3532");
        ignacio = new Miembro("Ignacio","Bisio","ignaci.bisio8780@gmail.com","1134223454");
        juan2 = new Miembro("Juan","Moscatelli","juanmoscatelli@gmail.com","491295402");
        maxiDeViajeros=new MiembroPorComunidad(maxi,viajeros,true);
        juanDeViajeros = new MiembroPorComunidad(juan,viajeros);
        tomDeViajeros = new MiembroPorComunidad(tom,viajeros);
        ignacioDeViajeros = new MiembroPorComunidad(ignacio,viajeros);
        juan2DeViajeros = new MiembroPorComunidad(juan2,viajeros);

        //creo incidentes
        incidente1 = new IncidenteMiembro("Incidente en EscaleraPlata 1", escaleraPlata, LocalDateTime.of(2023, 8, 21, 10, 0), paradaPlata, juanDeViajeros);
        incidente2 = new IncidenteMiembro("Incidente en Medrano", banioHMedrano, LocalDateTime.of(2023, 8, 21, 0, 0), paradaMedrano, juanDeViajeros);
        incidente3 = new IncidenteMiembro("Incidente en Carlos", banioMCarlos, LocalDateTime.of(2023, 8, 21, 0, 0), paradaCarlos, juanDeViajeros);
        incidente1.cerrarIncidente(LocalDateTime.of(2023, 8, 21, 2, 0),juanDeViajeros);

        //Creo los dos tipos de miembros
        observador= new TipoDeMiembro("Observador");
        noObservador= new TipoDeMiembro("Usuario de Servicio");

        juan.setUsuario(usuario1);
        maxi.setUsuario(usuario2);
        tom.setUsuario(usuario4);
        ignacio.setUsuario(usuario5);
        juan2.setUsuario(usuario6);
        juanDeViajeros.setTipoDeMiembro(noObservador);
        maxiDeViajeros.setTipoDeMiembro(noObservador);
        tomDeViajeros.setTipoDeMiembro(noObservador);
        ignacioDeViajeros.setTipoDeMiembro(noObservador);
        juan2DeViajeros.setTipoDeMiembro(observador);

    }
    @Test
    public void persistir(){
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);
        em.persist(usuario1);
        em.persist(usuario3);
        em.persist(usuario5);
        em.persist(usuario6);
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
        em.persist(usuario2);
        em.persist(maxi);
        em.persist(maxiDeViajeros);
        em.persist(usuario4);
        em.persist(tom);
        em.persist(tomDeViajeros);
        em.persist(ignacio);
        em.persist(juan2);
        em.persist(ignacioDeViajeros);
        em.persist(juan2DeViajeros);
        em.persist(admin);

        BDUtils.commit(em);
    }
    @Test
    public void carga(){
        Linea linea1 = new Linea("7", TipoDeTransporte.COLECTIVO);
        Linea linea2 = new Linea("A",TipoDeTransporte.SUBTE);
        Organizacion org1 = new Organizacion("Organizacion1","srl");
        ServicioPublico serv1 = new ServicioPublico(TipoDeTransporte.COLECTIVO);
        ServicioPublico serv2 = new ServicioPublico(TipoDeTransporte.TREN);
        ServicioPublico serv3 = new ServicioPublico(TipoDeTransporte.SUBTE);

        /*
        LineaRepo.getInstance().agregar(linea1);
        LineaRepo.getInstance().agregar(linea2);

        OrganizacionesRepo.getInstance().agregar(org1);

       ServicioPublicoRepo.getInstance().agregarServicio(new ServicioPublico(TipoDeTransporte.COLECTIVO));
       ServicioPublicoRepo.getInstance().agregarServicio(new ServicioPublico(TipoDeTransporte.TREN));
       ServicioPublicoRepo.getInstance().agregarServicio(new ServicioPublico(TipoDeTransporte.SUBTE));
       */
        EntityManager em = utils.BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);
        em.persist(linea1);
        em.persist(linea2);
        em.persist(org1);
        em.persist(serv1);
        em.persist(serv2);
        em.persist(serv3);
        BDUtils.commit(em);
    }
}
