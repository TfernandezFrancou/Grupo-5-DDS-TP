package domain.entities.repositorios;

import domain.entities.actores.Propietario;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PropietarioRepo {

    private List<Propietario> propietarios;

    public void agregarPropietario(Propietario propietario){
        propietarios.add(propietario);
    }

    public PropietarioRepo() {
        this.propietarios = new ArrayList<>();
    }
}
