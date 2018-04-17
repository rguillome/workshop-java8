package java8.ex01;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

            default int sumAge() {
            // TODO créer une méthode int sumAge()
            // TODO Cette méthode retourne le résultat de l'addition des ages des personnes
            int sum = 0;
            for (Person pers : findAll()) {
                sum+=pers.getAge();
                
            }

            return sum;
        }
    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    @Test
    public void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = daoA.sumAge();

        assertThat(result, is(210));
    }

    @Test
    public void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        int result = daoB.sumAge();

        assertThat(result, is(5050));

    }
}
