package domain.entities.repositorios;

import domain.entities.actores.OrganismoDeControl;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrganismoDeControlRepo {
    private List<OrganismoDeControl> organismosDeControl;

    public void agregarOrganismo(OrganismoDeControl org){
        this.organismosDeControl.add(org);
    }

    public OrganismoDeControlRepo() {
        this.organismosDeControl = new ArrayList<>();
    }
}
