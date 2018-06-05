
package first_semester_eksamen;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Cherry Rose Semeña & Emmely Lundberg
 */
public interface ServingHandler {
    
    /**
     * Convert a file to a String
     * @param filename The name of the file to be read
     * @return The file content as a String
     * @throws IOException if file is missing or locked
     */
    public String readFile(String filename) throws IOException;
    //Cherry
    /**
     * Converts file content to proper objects
     * @param data The file content as a String
     * @return a list of Serving objects
     * @throws TimeFormatException if time is formated badly
     */
    public ArrayList<Serving> getServings(String data) throws TimeFormatException;
    //Emmely
    /**
     * Identifies the Serving with the highest amount served.
     * @param servings The list of Samples based on file content
     * @return the identified Serving object
     */
    public Serving getHighestServing(ArrayList<Serving> servings);
    //Emmely
    /**
     * Identifies the Serving with the lowest amount served.
     * @param servings The list of Servings based on file content
     * @return the identified Serving object
     */
    public Serving getLessServing(ArrayList<Serving> servings);
    //Cherry
    /**
     * Identifies the servings with correct amount
     * compared to its predecessor.
     * @param servings The list of Samples based on file content - At least
     * 2 values are required
     * @return a new list containing the subset
     */
    public ArrayList<Serving> getValidServings(ArrayList<Serving> servings);
    //Emmely
    /**
     * Determines whether or not any serving surpasses the set limit.
     * Serving amount matter
     * @param serving The list of Servings based on file content
     * @return true if any served amount is greater than the limit,
     * false in any other case.
     */
    public boolean isTooMuch(Serving serving);

    //Cherry
    /**
     * sorts servings by amount
     * @param servings The list that will be sorted
     */
    public ArrayList<Serving> sortByAmount(ArrayList<Serving> servings);
    //Cherry
    /**
     * Retrieves a subset containing the too high servings
     * @param servings The list from which to get the subset
     * @return a new list containing the subset
     */
    public ArrayList<Serving> getTooHighServings(ArrayList<Serving> servings);
    //Cherry
    /**
     * Retrieves a subset containing only the servings that are below the minimum limit
     * @param servings The list from which to get the subset
     * @return a new list containing the subset
     */
    public ArrayList<Serving> getLessServings(ArrayList<Serving> servings);

    //Emmely
    /**
     * Retrieves an aggregation of the total amount above the maximum servings allowed
     * @param servings The list from which to get the subset
     * @return a new list containing the subset
     */
    public int getTotalExcessServings(ArrayList<Serving> servings);
    //Emmely
    /**
     * Retrieves the total amount missing for servings below minimum servings allowed
     * @param servings The list from which to get the subset
     * @return a new list containing the subset
     */
    public int getTotalMissingServings(ArrayList<Serving> servings);
}
