
package cjs.testfailproblem;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cherry Rose Semeña
 */
public class CatalogTest {
   
    private final Catalog underTest = new Catalog();

    /**
     * Test of addPerson method, of class Catalog.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddPerson() {
        assertEquals(0, underTest.getNrOfPeople());
        Person p = new Person(2015);
        underTest.addPerson(p);
    }

    /**
     * Test of getNrOfPeople method, of class Catalog.
     */
    @Test
    public void testGetNrOfPeople() {
        assertEquals(0, underTest.getNrOfPeople());
        Person p = new Person(1985);
        underTest.addPerson(p);
        assertEquals(1, underTest.getNrOfPeople());
    }
    
}
