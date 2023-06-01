package domain.entities.services.georef.entities;

import lombok.Getter;

@Getter
public class Municipio extends Localizacion {
    public Provincia provincia;

    public Provincia getProvincia(){
        return this.provincia;
    }

}
