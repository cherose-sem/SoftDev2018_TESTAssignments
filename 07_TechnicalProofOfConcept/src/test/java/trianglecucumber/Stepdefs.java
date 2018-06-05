package trianglecucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.Triangle;
import main.TriangleType;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 *
 * @author Cherry Rose Semeña
 */
public class Stepdefs {

    private Triangle triangle;
    private TriangleType actual;

    @Given("^The sides are (\\d+),(\\d+),(\\d+)$")
    public void the_sides_are(int arg1, int arg2, int arg3) throws Exception {
        this.triangle = new Triangle(arg1, arg2, arg3);
    }

    //this one is kinda tricky, this will test for an expected NumberFormatException
    //there might be a better way to do this
    @Given("^The sides are (\\d+), (\\d+) \"([^\"]*)\"$")
    public void the_sides_are(int arg1, int arg2, String arg3) throws Throwable {
        try{
            this.triangle = new Triangle(arg1, arg2, Integer.parseInt(arg3));
        }catch(Exception e){
            this.triangle = new Triangle(arg1, arg2);
        }
    }

    @Given("^The sides are (\\d+),(\\d+)$")
    public void the_sides_are(int arg1, int arg2) throws Throwable {
        this.triangle = new Triangle(arg1,arg2);
    }

    @When("^I ask what type of triangle$")
    public void i_ask_what_type_of_triangle() throws Exception {
        this.actual = triangle.getType();
    }

    @Then("^I should get \"([^\"]*)\"$")
    public void i_should_get(String arg1) throws Exception {
        assertThat(actual.toString(), is(arg1));
    }

}
