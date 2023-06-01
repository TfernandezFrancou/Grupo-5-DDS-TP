package domain.entities.repositorios;


import domain.entities.servicios.Linea;
import domain.entities.servicios.Organizacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LineaRepo {
    private static LineaRepo instance;
    private List<Linea> lineas;

    private LineaRepo() {
        this.lineas = new ArrayList<>();
    }

    public static LineaRepo getInstance() {
        if (instance == null) {
            instance = new LineaRepo();
        }
        return instance;
    }

    public Linea buscar(String nombre, String tipoTransporte) {
        Optional<Linea> lineaEncontrada = lineas.stream()
                .filter(linea -> linea.getNombre().equals(nombre)
                && linea.getTipoDeTransporte().toString().equals(tipoTransporte)).findFirst();
        if (lineaEncontrada.isPresent()){
            return lineaEncontrada.get();
        }else return null;
    }

    public void agregar(Linea linea){
        this.lineas.add(linea);
    }
}
