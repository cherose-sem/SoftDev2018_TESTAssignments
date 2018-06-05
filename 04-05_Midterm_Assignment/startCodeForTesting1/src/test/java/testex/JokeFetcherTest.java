package testex;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import testex.jokefetching.ChuckNorris;
import testex.jokefetching.EduJoke;

import testex.jokefetching.IFetcherFactory;
import testex.jokefetching.IJokeFetcher;
import testex.jokefetching.Moma;
import testex.jokefetching.Tambal;

/**
 *
 * @author Cherry Rose Semeña
 */
@RunWith(MockitoJUnitRunner.class)
public class JokeFetcherTest {

    @Mock
    private IDateFormatter dfMock;

    @Mock
    Moma moma;
    @Mock
    ChuckNorris chuck;
    @Mock
    EduJoke edu;
    @Mock
    Tambal tambal;

    @Mock
    private IFetcherFactory ffMock;

    private JokeFetcher jokeFetcher;

    @Before
    public void setup() throws Exception {
        List<IJokeFetcher> fetchers = Arrays.asList(edu, chuck, moma, tambal);
        when(ffMock.getJokeFetchers("EduJoke,ChuckNorris,Moma,Tambal")).thenReturn(fetchers);
        List<String> types = Arrays.asList("EduJoke", "ChuckNorris", "Moma", "Tambal");
        when(ffMock.getAvailableTypes()).thenReturn(types);
        jokeFetcher = new JokeFetcher(dfMock, ffMock);
        
        given(edu.getJoke()).willReturn(new Joke("What is a math teacher’s favorite sum?SUMMER.", "EducationalJokes.org"));
        given(chuck.getJoke()).willReturn(new Joke("Product Owners never ask Chuck Norris for more features. They ask for mercy.", "ChuckNorrisJokes.org"));
        given(moma.getJoke()).willReturn(new Joke("Yo momma so fat when she went to the circus the little girl asked if she could ride the elephant", "JoMamaJokes.org"));
        given(tambal.getJoke()).willReturn(new Joke("Tambal, ano daw?", "TambalaJokes.org"));
        
        
    }

    @Test
    public void testGetAvailableTypes() {
        assertThat(jokeFetcher.getAvailableTypes(), hasItems("EduJoke", "ChuckNorris", "Moma", "Tambal"));
        assertThat(jokeFetcher.getAvailableTypes().size(), is(4));
    }

    @Test
    public void testIsStringValid() {
        String jokeValidTokens = "EduJoke,ChuckNorris,Moma,Tambal";
        assertThat(jokeFetcher.isStringValid(jokeValidTokens), is(true));
        String jokeNonValidTokens = "EduJokez,ChuckNorrisz,Momaz,Tambalz";
        assertThat(jokeFetcher.isStringValid(jokeNonValidTokens), is(false));
    }

    @Test
    public void testGetJokesTimeZone() throws JokeException {
        given(dfMock.getFormattedDate(eq("Europe/Copenhagen"), anyObject())).willReturn("31 mar. 2018 11:08 PM");
        assertThat(jokeFetcher.getJokes("EduJoke,ChuckNorris,ChuckNorris,Moma,Tambal",
                "Europe/Copenhagen").getTimeZoneString(), is("31 mar. 2018 11:08 PM"));
        verify(dfMock, times(1)).getFormattedDate(eq("Europe/Copenhagen"), anyObject());
    }
    
    @Test
    public void testEduJoke() throws JokeException {
        String expectedJoke = "What is a math teacher’s favorite sum?SUMMER.";
        String expectedReference = "EducationalJokes.org";
        Jokes jokes = jokeFetcher.getJokes("EduJoke,ChuckNorris,Moma,Tambal", "Europe/Copenhagen");
        assertThat(jokes.getJokes().get(0).toString(), is(
         "Joke{" + "joke=" + expectedJoke + ", reference=" + expectedReference + '}'
        ) );
    }
    
    @Test
    public void testChuckNorrisJoke() throws JokeException {
        String expectedJoke = "Product Owners never ask Chuck Norris for more features. They ask for mercy.";
        String expectedReference = "ChuckNorrisJokes.org";
        Jokes jokes = jokeFetcher.getJokes("EduJoke,ChuckNorris,Moma,Tambal", "Europe/Copenhagen");
        assertThat(jokes.getJokes().get(1).toString(), is(
         "Joke{" + "joke=" + expectedJoke + ", reference=" + expectedReference + '}'
        ) );
    }
    
    @Test
    public void testMomaJoke() throws JokeException {
        String expectedJoke = "Yo momma so fat when she went to the circus the little girl asked if she could ride the elephant";
        String expectedReference = "JoMamaJokes.org";
        Jokes jokes = jokeFetcher.getJokes("EduJoke,ChuckNorris,Moma,Tambal", "Europe/Copenhagen");
        assertThat(jokes.getJokes().get(2).toString(), is(
         "Joke{" + "joke=" + expectedJoke + ", reference=" + expectedReference + '}'
        ) );
    }
    
     @Test
    public void testTambalJoke() throws JokeException {
        String expectedJoke = "Tambal, ano daw?";
        String expectedReference = "TambalaJokes.org";
        Jokes jokes = jokeFetcher.getJokes("EduJoke,ChuckNorris,Moma,Tambal", "Europe/Copenhagen");
        assertThat(jokes.getJokes().get(3).toString(), is(
         "Joke{" + "joke=" + expectedJoke + ", reference=" + expectedReference + '}'
        ) );
    }

}