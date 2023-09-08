package domain.entities.servicios;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Rankeable {
    @Column
    private String nombre;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

}
