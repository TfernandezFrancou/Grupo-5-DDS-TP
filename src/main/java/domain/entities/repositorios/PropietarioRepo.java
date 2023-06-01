package domain.entities.repositorios;

import domain.entities.actores.Propietario;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PropietarioRepo {

    private List<Propietario> propietarios;

    private static PropietarioRepo instance;

    private PropietarioRepo() {
        this.propietarios= new ArrayList<>();
    }

    public static PropietarioRepo getInstance() {
        if (instance == null) {
            instance = new PropietarioRepo();
        }
        return instance;
    }

    public void agregarPropietario(Propietario propietario){
        propietarios.add(propietario);
    }


}
