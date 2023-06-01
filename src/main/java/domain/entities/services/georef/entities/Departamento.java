package domain.entities.services.georef.entities;

import lombok.Getter;

public class Departamento extends Localizacion {
    public Provincia provincia;

    public Provincia getProvincia(){
        return this.provincia;
    }
}
