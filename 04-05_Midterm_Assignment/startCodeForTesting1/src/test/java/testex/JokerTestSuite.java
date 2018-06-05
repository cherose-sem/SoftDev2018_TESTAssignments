
package testex;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Cherry Rose Semeña
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({testex.JokeFetcherTest.class, 
    testex.DateFormatterTest.class,
    testex.jokefetching.FetcherFactoryTest.class})
public class JokerTestSuite {}
