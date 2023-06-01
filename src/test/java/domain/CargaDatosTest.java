package domain;

import domain.entities.actores.OrganismoDeControl;
import domain.entities.actores.Propietario;
import domain.entities.cargaDatos.LecturaCSV;
import domain.entities.repositorios.*;
import domain.entities.servicios.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CargaDatosTest {

    private LecturaCSV lectorCSV;

    @Before
    public void init(){

        Linea linea1 = new Linea("7",TipoDeTransporte.COLECTIVO);
        Linea linea2 = new Linea("A",TipoDeTransporte.SUBTE);


        LineaRepo.getInstance().agregar(linea1);
        LineaRepo.getInstance().agregar(linea2);

        OrganizacionesRepo.getInstance().agregar(new Organizacion("Organizacion1","srl"));

       ServicioPublicoRepo.getInstance().agregarServicio(new ServicioPublico(TipoDeTransporte.COLECTIVO));
       ServicioPublicoRepo.getInstance().agregarServicio(new ServicioPublico(TipoDeTransporte.TREN));
       ServicioPublicoRepo.getInstance().agregarServicio(new ServicioPublico(TipoDeTransporte.SUBTE));



        lectorCSV = new LecturaCSV();
    }

    @Test
    public void carga(){
        List<Propietario> propietarios =PropietarioRepo.getInstance().getPropietarios();
        List<OrganismoDeControl> organismos = OrganismoDeControlRepo.getInstance().getOrganismosDeControl();
        for (Propietario p : propietarios) {
            System.out.println(p.getNombre());
            System.out.println(p.getServicioPublico().getTipoDeTransporte());
        }
        for (OrganismoDeControl org : organismos) {
            System.out.println(org.getNombre());
            System.out.println(org.getEntidad().getNombre());
        }

        Assert.assertEquals(propietarios.size(),3);
        Assert.assertEquals(organismos.size(),3);
    }
}
