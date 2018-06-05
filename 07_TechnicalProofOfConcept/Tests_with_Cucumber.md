# Acceptance Test with Cucumber

_1. Examine Cucumber: Set up small Cucumber project with
Feature, Scenario(s), and step definitions <br>
a) Make sure your project has a number of input values that need to be
tested in combination. <br>
b) It doesn’t have to be app with (G)UI_

Cucumber is a tool for communication, collaboration and testing used between the non-technical people and technical people. It supports Behaviour-Driven Development, which automates the validation of the software does what the specifications states. It uses Gherkin syntax to translate/understand scenarios and execute the step definitions. 
Step Definitions map/glue each Gherkin step defined in the feature file.

### Implementation 

A. First, we defined features of the triangle program:<br>
_get_triangle.feature_<br>
![image](https://user-images.githubusercontent.com/16150075/39947234-79346f46-5571-11e8-8a66-dc3c5d07dbee.png)

_invalid_triangle.feature_<br>
![image](https://user-images.githubusercontent.com/16150075/39947280-9f3b5092-5571-11e8-9937-711af9a065f6.png)

B. After build, these scenarios will be translated into runnable methods that should be implemented and served as step definitions. 

```
 @Given("^The sides are (\\d+),(\\d+),(\\d+)$")
    public void the_sides_are(int arg1, int arg2, int arg3) throws Exception {
        this.triangle = new Triangle(arg1, arg2, arg3);
    }

    //HERE we are expecting for a NumberFormatException
    //By design, if the input is not a number it will be  interpreted as missing argument
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
```

C. Test Result: <br>
![alt text](https://github.com/Ansty93/Soft_test_cucumber/blob/master/CucumberTestResult.jpg)


_WHAT WE HAVE LEARNED?_
- Turning acceptance criteria into executable specifications, which becomes automated acceptance test.
- With the use of defined scenarios, we ensures that the system's behavior complies to the set of rules for a certain feature.
- All parts in the agile testing pyramid can be implemented using Cucumber, and in our shown implementation, we used it in lowest part, unit tests. It ensures that the Triangle program met all the set of rules for the feature of getting the type of a triangle.
- Though Cucumber is not a testing tool, it is a tool for capturing common understanding on how the system should work(based on BDD).

### HOW TO USE IT IN OUR GUTENBERG PROJECT
We have defined the acceptance criterias first thing before we started the project, so it is just a matter of deciding how and where should we implement it. Since Cucumber is very flexible in all the three layers in the agile testing pyramid, we are planning to do it in the integration layer wherein it will be integrated with the RESTAssured Test that we already specified like this:<br>

![image](https://user-images.githubusercontent.com/16150075/39965653-73725974-569d-11e8-97ac-1fb6462221cd.png)





