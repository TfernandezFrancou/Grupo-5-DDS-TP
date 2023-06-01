package domain.entities.repositorios;

import domain.entities.servicios.Organizacion;
import domain.entities.servicios.ServicioPublico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//es singleton
public class OrganizacionesRepo {
    private List<Organizacion> organizaciones;

    private static OrganizacionesRepo instance;

    private OrganizacionesRepo() {
        this.organizaciones = new ArrayList<>();
    }

    public static OrganizacionesRepo getInstance() {
        if (instance == null) {
            instance = new OrganizacionesRepo();
        }
        return instance;
    }

    public Organizacion buscar(String nombre){
        Optional<Organizacion> organizacionEncontrada = organizaciones.stream()
                .filter(org -> org.getNombre().equals(nombre)).findFirst();
        if (organizacionEncontrada.isPresent()){
            return organizacionEncontrada.get();
        }else return null;
    }

    public void agregar(Organizacion org){this.organizaciones.add(org);}
}
