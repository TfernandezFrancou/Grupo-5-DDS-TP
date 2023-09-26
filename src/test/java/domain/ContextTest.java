package domain;

import domain.entities.actores.Comunidad;
import domain.entities.actores.miembros.Miembro;
import domain.entities.actores.miembros.MiembroPorComunidad;
import org.junit.Assert;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;
import utils.BDUtils;

import javax.persistence.EntityManager;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertNotNull;

public class ContextTest extends AbstractPersistenceTest implements WithGlobalEntityManager {
    @Test
    public void contextUp() {
        assertNotNull(entityManager());
    }

    @Test
    public void contextUpWithTransaction() {
        withTransaction(() -> {});
    }



    @Test
    public void init(){
        EntityManager em = BDUtils.getEntityManager();
        BDUtils.comenzarTransaccion(em);

        Miembro miembro1 = new Miembro("Jorge","Perez","hola@gmail.com","123");
        Comunidad comunidad1 = new Comunidad();
        em.persist(comunidad1);
        MiembroPorComunidad miembroPorComunidad1 = new MiembroPorComunidad(miembro1, comunidad1);
        em.persist(miembroPorComunidad1);
        miembro1.setComunidades(Collections.singletonList(miembroPorComunidad1));
        em.persist(miembro1);

        List<Miembro> miembros = em.createQuery("select m from Miembro m where m.apellido = ?1", Miembro.class)
                .setParameter(1,"Perez").getResultList();

        Assert.assertEquals(miembros.stream().findFirst().get().getApellido(),"Perez");


        BDUtils.commit(em);
    }

}

