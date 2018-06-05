# Testing Real Life Code
> _JavaANPR-Automatic Number Plate Recognition System for Java_

● Explain the purpose of the Test (what the original test exposed, and what your test exposes) <br>
> _Test is a decision that we should face to ensure the quality of a project. 
In this assignment, we have practiced the way of understanding and refactoring somebody else's code/tests, and implement a way more effective testing technique._ <br><br>
_A. In the original test: https://github.com/cph-cs241/TEST_Assignments_1Sem2018/blob/master/Midterm_Assignment/javaANPR/RecognitionIT.java_<br>

![image](https://user-images.githubusercontent.com/16150075/38174988-f85473c2-35d5-11e8-82f4-09f0f6234448.png)
![image](https://user-images.githubusercontent.com/16150075/38175002-1aa6fd96-35d6-11e8-94c8-4c6391ebd62d.png)

_There are some problems that this way of testing would encounter. The `intelligenceSingleTest()` will just test a single image, it may passed/fail. The `testAllSnapshots()` will also be a problem since it is not reporting which image has failed/succeed and the issue of being dependent on the `correctCount`, there is a risk of an image will not match to the expected result due to some changes in the code._<br><br>
_B. In the new test: https://github.com/cph-cs241/TEST_Assignments_1Sem2018/blob/master/Midterm_Assignment/javaANPR/RecognitionAllIT.java_<br>

![image](https://user-images.githubusercontent.com/16150075/38175163-334d32fa-35d8-11e8-9ab8-d267c75b0ef7.png)

_The new test class could now report the images passed/failed which solve the problem mentioned in the original test class. All the data given has been tested._

● Explain about Parameterized Tests in JUnit and how you have used it in this exercise. <br>
> _Parameterized Tests has the purpose of runninng the same test with different values. It is the best way to deal with the testing of all the data/images given on this exercise. _<br>

● Explain the topic Data Driven Testing, and why it often makes a lot of sense to read test data from a file. <br>
> _Data Driven Testing is a way to get excellect coverage while minimizing the amoout of test code that we write and maintain. It is often that we have tests which are just slightly different, and may only differ on inputs. That's why it makes sense to store all the dataset in a file and write an interpreter that reads the file and executes the tests._<br>

● Your answers to the question; whether what you implemented was a Unit Test or a JUnit Test, the problems you might have discovered with the test and, your suggestions for ways this could have been fixed. <br>
> _I think it is still JUnit Test which is making assertions for testing expected results by executing repeatable tests, and since we are working with Java. See the implementation of `RecognitionAllIT` test class ;-)_<br>

● The steps you took to include Hamcrest matchers in the project, and the difference they made for the test <br>
>_Add depedency for using Hamcrest matchers in pom.xml:_<br>

```
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-library</artifactId>
    <version>1.3</version>
    <scope>test</scope>
</dependency>
```

_Hamcrest is very useful in creating matcher objects which is often used in automated testing. It makes the tests easy to understand/read like: "Assert that expected plate is read" (last line in the image below)_

![image](https://user-images.githubusercontent.com/16150075/38175405-40750864-35dc-11e8-9496-1f2d95accaf0.png)


__SUBMITTED BY: CHERRY ROSE SEMEÑA__
