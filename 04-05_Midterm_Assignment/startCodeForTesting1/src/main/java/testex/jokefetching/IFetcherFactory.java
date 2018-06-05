
package testex.jokefetching;

import java.util.List;
import testex.JokeException;

/**
 *
 * @author Cherry Rose Semeña
 */
public interface IFetcherFactory {
    List<String> getAvailableTypes();
    List<IJokeFetcher> getJokeFetchers(String jokesToFetch) throws JokeException;
}
