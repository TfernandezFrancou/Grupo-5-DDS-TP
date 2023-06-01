package domain.entities.repositorios;

import domain.entities.actores.OrganismoDeControl;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class OrganismoDeControlRepo {
    private List<OrganismoDeControl> organismosDeControl;

    private static OrganismoDeControlRepo instance;

    private OrganismoDeControlRepo() {
        this.organismosDeControl= new ArrayList<>();
    }

    public static OrganismoDeControlRepo getInstance() {
        if (instance == null) {
            instance = new OrganismoDeControlRepo();
        }
        return instance;
    }

    public void agregarOrganismo(OrganismoDeControl org){
        this.organismosDeControl.add(org);
    }

}
