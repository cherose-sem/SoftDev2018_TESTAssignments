
package myBugs;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cherry Rose Semeña
 */
public class MyArrayListWithBugsTest {
    MyArrayListWithBugs instance;

    /**
     * Test Case 01: Start State - New Empty List
     */
    @Test
    public void T01_createEmptyList() {
        System.out.println("Test Case 01: Start State - New Empty List");
        instance = new MyArrayListWithBugs();
        assertEquals(instance.size(), 0);
    }
    
    /**
     * Test Case 02: New Empty List - Expanded List
     */
    @Test
    public void T02_testGetLongerList() {
        System.out.println("Test Case 02: New Empty List - Expanded List");
        instance = new MyArrayListWithBugs();
        assertEquals(instance.getLongerList().length, 10); //initial capacity is 5
    }
    
    /**
     * Test Case 03: Expanded list - Elements in the list
     */
    @Test
    public void T03_testAdd01() {
        System.out.println("Test Case 03: Expanded list - Elements in the list");
        instance = new MyArrayListWithBugs();
        instance.add("Element01");
        assertEquals(instance.size(), 1);
    }

    /**
     * Test Case 04: Expanded list - Elements in the list
     */
    @Test
    public void T04_testAdd02() {
        System.out.println("Test Case 04: Expanded list - Elements in the list");
        instance = new MyArrayListWithBugs();
        instance.add("Element01");
        instance.add(1, "Element02");
        assertEquals(instance.size(), 2);
    }
    
    /**
     * Test Case 05: Expanded list - Error Exception
     */
    @Test (expected = IndexOutOfBoundsException.class) 
    public void T05_testAdd03() {
        System.out.println("Test Case 05: Expanded list - Error Exception");
        instance = new MyArrayListWithBugs();
        instance.add("Element01");
        instance.add(-1, "Element02");
        assertEquals(instance.size(), 1);
    }
    
    /**
     * Test Case 06: Elements in the list - Element Added
     */
    @Test
    public void T06_testGet01() {
        System.out.println("Test Case 06: Elements in the list - Element Added");
        instance = new MyArrayListWithBugs();
        instance.add("Element01");
        instance.add("NEW_ELEMENT");
        Object res = instance.get(instance.size()-1);
        assertEquals(res, "NEW_ELEMENT");
    }
    
    /**
     * Test Case 07: Elements in the list - Error Exception
     */
    @Test (expected = IndexOutOfBoundsException.class) 
    public void T07_testGet02() {
        System.out.println("Test Case 07: Elements in the list - Error Exception (IndexOutOfBounds)");
        instance = new MyArrayListWithBugs();
        instance.add("Element01");
        instance.get(-1);
    }
    
    /**
     * Test Case 08: Elements in the list - Error Exception
     */
    @Test (expected = NullPointerException.class) 
    public void T08_testGet03() {
        System.out.println(" Test Case 08: Elements in the list - Error Exception (NullPonterException)");
        instance = new MyArrayListWithBugs();
        instance.add("Element01");
        instance.get(1);
    }
    
}
