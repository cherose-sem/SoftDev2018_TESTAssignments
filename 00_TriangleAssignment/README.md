# TEST_GetStartedExercise_Triangles
I. Design of test cases

_Make a set of test cases(i.e. specific sets of data) that will adequately test this program:_

_The program reads three integer values from an input dialog. The three values represent the lengths of the sides of a triangle. The program displays a message that states whether the triangle is scalene (no equal sides), isosceles (two sides are equal), or equilateral (all sides are equal)._

:white_check_mark: Step 1: Design test cases (on paper) for both successful and unsuccessful scenarios.

| TEST CASE|       INPUT      |          EXPECTED        |          ACTUAL          |         STATUS           |
|----------|------------------|--------------------------|--------------------------|--------------------------|
|    1     |      7,10,5      |          scalene         |          scalene         |         passed           |
|    2     |      7,5,7       |          isosceles       |         isosceles        |         passed           |
|    3     |      7,7,7       |          equilateral     |        equilateral       |         passed           |
|    4     |   1,2,"hello"    |          invalid         |       invalid : NaN      |         passed           |
|    5     |       1,2        |          invalid         |   invalid : undefined    |         passed           |
|    6     |       1,0,2      |          invalid         | invalid : side length 0  |         passed           |
|    7     |       1,2,3      |          invalid         | invalid : no triangle    |         passed           |


![image](https://user-images.githubusercontent.com/16150075/36351204-af898678-14a6-11e8-8767-365416beab8a.png)


:white_check_mark: Step 2: Design and implement the Triangle program in a programming language (e.g. Java or C#)
  - you don't have to write unit tests, but you may do so :)
  - No need for a nice GUI, just console app is fine
  
 #### Code Metrics - Cyclomatic complexity
![image](https://user-images.githubusercontent.com/16150075/36351217-d630df1a-14a6-11e8-8e88-f382b2d7960a.png)

##### _Solution:_ 
In order to reduce CC, I created new functions that would separate the logic of getting the result of the type of the triangle. 

 #### SETUP:
 `git clone https://github.com/cph-cs241/TEST_GetStartedExercise_Triangles.git` -> clone the project

 #### RUN:   
 * `node index x y z` -> x, y and z represents the sides length of the triangle
 * `node test.js` -> run the tests
 * `node runjsmeter.js index.js`  -> check the code metrics

 :white_check_mark: See the other exercises in _TEST_Assignment2_CJS.pdf_
 
 
