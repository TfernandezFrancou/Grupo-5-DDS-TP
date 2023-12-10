package domain;

import domain.entities.actores.OrganismoDeControl;
import domain.entities.actores.Propietario;
import domain.entities.cargaDatos.LecturaCSV;
import domain.entities.repositorios.*;
import domain.entities.servicios.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.BDUtils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CargaDatosTest {

    private LecturaCSV lectorCSV;

    @Test
    public void carga(){

        Linea linea1 = new Linea("7",TipoDeTransporte.COLECTIVO);
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
        lectorCSV = new LecturaCSV();

        List<Propietario> propietarios =PropietarioRepo.getInstance().buscarPropiertarios();
        List<OrganismoDeControl> organismos = OrganismoDeControlRepo.getInstance().buscarOrganismos();

        for (Propietario p : propietarios) {
            System.out.println(p.getNombre());
            System.out.println(p.getServicioPublico().getTipoDeTransporte());
        }
        for (OrganismoDeControl org : organismos) {
            System.out.println(org.getNombre());
            System.out.println(org.getEntidad().getNombre());
            System.out.println(org.getEntidad().getTipoDeTransporte());
        }

        Assert.assertEquals(propietarios.size(),3);
        Assert.assertEquals(organismos.size(),3);
    }
}
