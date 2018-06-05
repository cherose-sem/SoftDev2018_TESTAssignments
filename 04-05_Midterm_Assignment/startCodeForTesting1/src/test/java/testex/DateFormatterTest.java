package testex;

import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cherry Rose Semeña
 */
public class DateFormatterTest {

    private IDateFormatter df;

    public DateFormatterTest() {
    }

    @Before
    public void setup() {
        df = new DateFormatter();
    }

    @Test
    public void testGetFormattedDateCph() throws Exception {
        String expectedCph = "31 Mar 2018 11:08 PM";
        assertThat(df.getFormattedDate("Europe/Copenhagen", new Date(2018 - 1900, 2, 31, 23, 8)), is(expectedCph));
    }
    
    @Test
    public void testGetFormattedDateMnl() throws Exception {
        String expectedMnl = "01 Apr 2018 05:08 AM"; //Philippiines is 6 hrs advance than Denmark ;)
        assertThat(df.getFormattedDate("Asia/Manila", new Date(2018 - 1900, 2, 31, 23, 8)), is(expectedMnl));
    }

    @Test(expected = JokeException.class)
    public void testJokeException() throws JokeException {
        df.getFormattedDate("unknown timezone", new Date());
    }
}
