package domain.entities.services.georef.entities;

import java.util.List;

public class ListadoDeProvincias {
    public int cantidad;
    public int inicio;
    public int total;
    public List<Provincia> provincias;
    public Parametro parametros;

    private class Parametro{
        public List<String> campos;
    }
}
