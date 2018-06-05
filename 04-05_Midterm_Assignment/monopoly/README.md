# Monopoly
> Own project/application and testing with mock objects in TDD approach (writing test before code)

Explain your solution with focus on its design. Does it have low coupling, interfaces, polymorphism, Inversion of Control and Dependency injection as central design principles? If not, why? Otherwise, demonstrate it! <br>
> _Based on the UML sequence diagram and instructions, the `Player.takeTurn()` was implemented and the dependent classes are just interfaces._<br>

![image](https://user-images.githubusercontent.com/16150075/38215257-77807ff0-36c7-11e8-80b1-3bae28aacbb1.png)

> _I decided to explore the other way of solving the problem, with stubs of Martin Fowler concepts. It is a common helper to testing environments, which  provide canned answers to calls made during the test, usually not responding at all to anything outside what's programmed in for the test._<br>

> _IMPLEMENTATION_<br>
![image](https://user-images.githubusercontent.com/16150075/38215708-f890c7b6-36c8-11e8-8a8d-6cc704adf894.png)

> _Sample test_<br>
![image](https://user-images.githubusercontent.com/16150075/38215859-5b25ea50-36c9-11e8-90ff-3cfd90601219.png)

> _this will return the sum of the 2 dice as 10, that's why we are expecting that it is gonna move 10 steps from its location_<br>
![image](https://user-images.githubusercontent.com/16150075/38215884-6baac7ba-36c9-11e8-94d0-9c6b96971bd3.png)

> _TEST RESULT_<br>
![image](https://user-images.githubusercontent.com/16150075/38216027-d173897e-36c9-11e8-8b04-e729d8a4bd5d.png)

Explain your test case design activity and argument for the choices that you have made:  <br>
• how to choose the right test conditions (i.e. what to test which in principle will be all code when you are a TDD’er  )? <br>
> _Test conditions are the input that we are giving to test the application, it could also be functionalities just like when we test `takeTurn()`. It must focus to test those parts that impact the behavior or state of the system._<br>

• what test design techniques to use (both consider black-box techniques and white-box technique)? <br>
> _In most cases, white-box technique is ideally used by developers since it requires to know the system. On the other hand, black-box technique is widely used for testers who doesn't know the system, a matter of input and output verification for systems and acceptance testing._<br>

• how much effort to put into each test condition (how critical is the item will influence it’s test coverage percentage)? <br>
> _A rule of thumb: 80%_<br>

> _Here is the test coverage percentage on this assignment:_<br>
![image](https://user-images.githubusercontent.com/16150075/38216604-960d532c-36cb-11e8-81fd-f089e35e2a71.png)

__SUBMITTED BY: CHERRY ROSE SEMEÑA__
