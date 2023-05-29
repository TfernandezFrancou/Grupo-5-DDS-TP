package domain;

import domain.entities.actores.OrganismoDeControl;
import domain.entities.actores.Propietario;
import domain.entities.cargaDatos.LecturaCSV;
import domain.entities.repositorios.OrganismoDeControlRepo;
import domain.entities.repositorios.PropietarioRepo;
import domain.entities.repositorios.ServicioPublicoRepo;
import domain.entities.repositorios.TipoDeServicioRepo;
import domain.entities.servicios.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CargaDatosTest {

    private OrganismoDeControlRepo organismoDeControlRepo;
    private ServicioPublicoRepo servicioPublicoRepo;
    private PropietarioRepo propietarioRepo;
    private TipoDeServicioRepo tipoDeServicioRepo;
    private LecturaCSV lectorCSV;

    @Before
    public void init(){

        servicioPublicoRepo= new ServicioPublicoRepo();
        servicioPublicoRepo.agregarServicio(new ServicioPublico(TipoDeTransporte.COLECTIVO,new Linea("54")));
        servicioPublicoRepo.agregarServicio(new ServicioPublico(TipoDeTransporte.TREN,new Linea("sarmiento")));
        servicioPublicoRepo.agregarServicio(new ServicioPublico(TipoDeTransporte.SUBTE,new Linea("H")));

        tipoDeServicioRepo = new TipoDeServicioRepo();
        tipoDeServicioRepo.agregar(new TipoDeServicio("hombre",new AgrupacionServicio("banio")));
        tipoDeServicioRepo.agregar(new TipoDeServicio("rivadavia",new AgrupacionServicio("escalera")));
        tipoDeServicioRepo.agregar(new TipoDeServicio("alberdi",new AgrupacionServicio("ascensor")));

        propietarioRepo = new PropietarioRepo();
        organismoDeControlRepo = new OrganismoDeControlRepo();

        lectorCSV = new LecturaCSV(servicioPublicoRepo,tipoDeServicioRepo,propietarioRepo,organismoDeControlRepo);
    }

    @Test
    public void carga(){
        List<Propietario> propietarios = lectorCSV.getPropietarioRepo().getPropietarios();
        List<OrganismoDeControl> organismos = lectorCSV.getOrganismoDeControlRepo().getOrganismosDeControl();
        for (Propietario p : propietarios) {
            System.out.println(p.getNombre());
        }
        for (OrganismoDeControl org : organismos) {
            System.out.println(org.getNombre());
        }

        Assert.assertEquals(propietarios.size(),3);
        Assert.assertEquals(organismos.size(),3);
    }

}
