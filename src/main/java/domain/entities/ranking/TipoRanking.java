package domain.entities.ranking;


import javax.persistence.*;

@Entity
@Table
public class TipoRanking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipoRanking_codigo;
    @Column
    private String nombre;
    public TipoRanking(String nom){this.nombre =nom; }

    public TipoRanking() {

    }
}
