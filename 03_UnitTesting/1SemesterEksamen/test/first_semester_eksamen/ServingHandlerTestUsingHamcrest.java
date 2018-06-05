/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first_semester_eksamen;

import impl.ServingHandlerImpl;
import impl.ServingImpl;
import impl.Time;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

/**
 *
 * @author Cherry Rose Semeña & Emmely Lundberg
 */
public class ServingHandlerTestUsingHamcrest {
    
    ServingHandler instance;
    ArrayList<Serving> servings;
    
    public ServingHandlerTestUsingHamcrest() {
    }
    
    @Before
    public void setUp() {
        instance = new ServingHandlerImpl();
        this.servings = new ArrayList();
        Time t = new Time("10:01");
        this.servings.add(new ServingImpl("24-12-2017", t, 157, "André"));
        this.servings.add(new ServingImpl("24-12-2017", t, 147, "Sofia"));
        this.servings.add(new ServingImpl("24-12-2017", t, 142, "Paula"));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetHighestServing() {
        System.out.println("getHighestServing");
        int expResult = 157;
        Serving result = instance.getHighestServing(servings);
        assertThat(result, is(any(Serving.class)));
        assertThat(result.getAmount(), is(equalTo(expResult)));
    }
    
    @Test
    public void testSortByAmount(){
        System.out.println("sortByAmount");
        instance.sortByAmount(servings);
        for (int i = 0; i < servings.size()-1; i++) {
            int first = servings.get(i).getAmount();
            int next = servings.get(i+1).getAmount();
            assertThat(first, is(lessThanOrEqualTo(next))); //lessThan is only working on lower version of hamcrest 1.2
        }
    }
}
