# TEST_Assignment4_UnitTesting
#### _by: Cherry Rose Semeña and Emmely Lundberg_

### DAT first semester exam

_In this assignment you decide which programming language you use, as long as it is objectoriented. How ever one subtask is to use Junit 5, so you must this small part must be Java.
The assignment is solved in pairs and the solution will be presented (to me) on Monday 5/3-2018 Where we also will upload to Moodel._

- Write an interface with 10 simple methods. For instance a method which accepts a list of elements and sorts the list. Or maybe it returns a subset.
The difficulty level can be inferred from the example on Moodle.
- If your methods  uses your own datatypes or other resources, you will have to provide these.
- Write unit tests, which tests all methods. Remember to test edge values and equivalent classes.
- Solve the assignment you have written – That is  write an implementation of your interface which passes all your tests.
- When you have written 10 methods, translate 2 of these to Java and test them using JUnit 5.

### Solution: 
#### _See the first release for this assignment_ [_here_](https://github.com/cph-cs241/TEST_Assignment4_UnitTesting/releases/tag/exam1)

##### Assignment Description: 
There is a data set for wine servings. An interface with some methods was provided to manage the data given for making inventories and determining how much wine has been served too much/less and by whom(waiter), as well as sorting it by amount of servings. Find the Servings data [here](https://github.com/cph-cs241/TEST_Assignment4_UnitTesting/blob/master/1SemesterEksamen/Servings.csv) .


- [x] Interface with 10 simple methods: [_ServingHandler.java_](https://github.com/cph-cs241/TEST_Assignment4_UnitTesting/blob/master/1SemesterEksamen/src/first_semester_eksamen/ServingHandler.java)
- [x] Object used: [_Serving.java(interface)_](https://github.com/cph-cs241/TEST_Assignment4_UnitTesting/blob/master/1SemesterEksamen/src/first_semester_eksamen/Serving.java) and
[_ServingImpl.java(implementation)_](https://github.com/cph-cs241/TEST_Assignment4_UnitTesting/blob/master/1SemesterEksamen/src/impl/ServingImpl.java)
- [x] JUnit 4 Tests(10 methods): [_TestServingHandler.java_](https://github.com/cph-cs241/TEST_Assignment4_UnitTesting/blob/master/1SemesterEksamen/test/first_semester_eksamen/ServingHandlerTest.java)
- [x] Implementation: [_ServingHandlerImpl.java_](https://github.com/cph-cs241/TEST_Assignment4_UnitTesting/blob/master/1SemesterEksamen/src/impl/ServingHandlerImpl.java)
- [x] JUnit 5 (2 methods) - [_TwoServingHndlerImplTestJUnit5.java_](https://github.com/cph-cs241/TEST_Assignment4_UnitTesting/blob/master/1SemesterEksamen/test/first_semester_eksamen/TwoServingHandlerImplTestJUnit5.java)

### ---------------------------------------------------------------------------------------------

### DAT first semester exam 2

_Continuing your work from last week, this week you will first of all improve your code (if it needs improving) so that it is easily testable - Expect heavy use of dependency injection.Last week you wrote 2 methods (at least) in java._

- This week you have to write 2 methods using Hamcrest or similar ("Fluent assertions for .NET). If you have used another language and can't find a library that is similar, you can always use Hamcrest on the 2 methods you wrote in java.
- Also you have to write 2 test methods that are "data driven" - No hard coded data! Your data-set doesn't have to be large, but it has to be representative of a proper set.

### Solution:

#### _Testing 2 methods using Hamcrest:_

Hamcrest is very useful in creating matcher objects which is often used in automated testing. It is designed to make the tests readable by using static methods that creates an assertion grammar. In our solution, you find it easy to understand by simply reading it, like “Assert that result is any Serving class”, “Assert that result’s amount is equal to the expected result”, “Assert that first is less than or equal to next”. There are some more matchers that can be used such as anything(), arrayContaining(),startsWith(), endsWith(),  arrayContainingInAnyOrder(), and so on. 

![image](https://user-images.githubusercontent.com/16150075/37231599-051c59ea-23ec-11e8-88f6-1a9dcd8144f0.png)

![image](https://user-images.githubusercontent.com/16150075/37231613-125cf52e-23ec-11e8-90d9-817f6d125465.png)

#### _Data Driven Test for 2 methods:_

We have chosen Excel documents (.xls) as the source for the data driven test.
The reasoning behind choosing Excel documents are formats are because that non technical person can read/write which increases the number of people that contribute to the test data in a project. The code and inspiration for reading the Excel sheet has been taken from this article. Inspiration: https://dzone.com/articles/data-driven-tests-junit-4-and.

Excerpts from the article:
_“Data-driven testing is a great way to test calculation-based applications more thoroughly. In a real-world application, this Excel spreadsheet could be provided by the client or the end-user with the business logic encoded within the spreadsheet.”
“The SpreadsheetData class uses the Apache POI project to load data from an Excel spreadsheet and transform it into a list of Object arrays compatible with the @Parameters annotation”_

This is the code for testing getTotalExcessServings with data driven test: 
##### Data from Excel sheet:
![image](https://user-images.githubusercontent.com/16150075/37251275-53edfcf0-250d-11e8-82dd-54bb87ab53cd.png)

##### Test Code
![image](https://user-images.githubusercontent.com/16150075/37251278-6efee5ae-250d-11e8-814d-3084577ed942.png)

##### Test Result
![image](https://user-images.githubusercontent.com/16150075/37251281-7f8078d4-250d-11e8-9530-9aafa2a69a5d.png)

This is the code for testing getValidServings with data driven test: 
##### Data from Excel sheet:
![image](https://user-images.githubusercontent.com/16150075/37251287-9a50b368-250d-11e8-94c1-9c22bd8111ac.png)

##### Test Code
![image](https://user-images.githubusercontent.com/16150075/37251295-affd05b8-250d-11e8-9ee8-efa7b8abecb4.png)

##### Test Result
![image](https://user-images.githubusercontent.com/16150075/37251299-bcdf0290-250d-11e8-8a64-d3fe843800bf.png)

