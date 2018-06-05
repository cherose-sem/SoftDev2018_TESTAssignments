
package testex.jokefetching;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Cherry Rose Semeña
 */
@RunWith(MockitoJUnitRunner.class)
public class FetcherFactoryTest {
   
    IFetcherFactory factory;
        
    @Mock
    EduJoke eduJokeMock;
    
    @Mock
    ChuckNorris chuckNorrisMock;
    
    @Mock
    Moma momaMock;
    
    @Mock
    Tambal tambalMock;    
 
    @Before
    public void setup() {
        factory = new FetcherFactory(eduJokeMock, chuckNorrisMock, momaMock, tambalMock);
    }

    @Test
    public void testThatFactoryHasFourInstancesOfIJokeFetcher() throws Exception {
        List<IJokeFetcher> result = factory.getJokeFetchers("EduJoke,ChuckNorris,Moma,Tambal");
        assertThat(result.size(), is(4));
        assertThat(result.get(0), is(instanceOf(EduJoke.class)));
        assertThat(result.get(1), is(instanceOf(ChuckNorris.class)));
        assertThat(result.get(2), is(instanceOf(Moma.class)));
        assertThat(result.get(3), is(instanceOf(Tambal.class)));
        
    }
    
}
