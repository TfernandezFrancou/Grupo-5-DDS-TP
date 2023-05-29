package domain.entities.cargaDatos;

import domain.entities.actores.OrganismoDeControl;
import domain.entities.actores.Propietario;
import domain.entities.repositorios.OrganismoDeControlRepo;
import domain.entities.repositorios.PropietarioRepo;
import domain.entities.repositorios.ServicioPublicoRepo;
import domain.entities.repositorios.TipoDeServicioRepo;
import lombok.Getter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;


@Getter
public class LecturaCSV {

    private ServicioPublicoRepo servicioPublicoRepo;
    private TipoDeServicioRepo tipoDeServicioRepo;
    private OrganismoDeControlRepo organismoDeControlRepo;
    private PropietarioRepo propietarioRepo;
    private static final String rutaArchivo = "src/main/java/domain/entities/cargaDatos/datos.csv";
    Reader reader;

    public LecturaCSV(ServicioPublicoRepo servicioPublicoRepo,
                      TipoDeServicioRepo tipoDeServicioRepo,
                      PropietarioRepo propietarioRepo,
                      OrganismoDeControlRepo organismoDeControlRepo) {
        this.servicioPublicoRepo = servicioPublicoRepo;
        this.tipoDeServicioRepo = tipoDeServicioRepo;
        this.propietarioRepo = propietarioRepo;
        this.organismoDeControlRepo = organismoDeControlRepo;

        {
            try {
                reader = Files.newBufferedReader(Paths.get(rutaArchivo));

                CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);

                for (CSVRecord registro : parser){
                    String nombre = registro.get(0);
                    String tipo = registro.get(1);
                    String servicio = registro.get(2);
                    String tipoServicio = registro.get(3);


                    if(Objects.equals(tipo, "propietario")){
                        Propietario entidadPropietaria = new Propietario(nombre,servicioPublicoRepo.buscar(servicio,tipoServicio));
                        this.propietarioRepo.agregarPropietario(entidadPropietaria);
                    }else{
                        OrganismoDeControl organismoControl = new OrganismoDeControl(nombre,
                                tipoDeServicioRepo.buscar(servicio,tipoServicio));
                        this.organismoDeControlRepo.agregarOrganismo(organismoControl);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }


}
