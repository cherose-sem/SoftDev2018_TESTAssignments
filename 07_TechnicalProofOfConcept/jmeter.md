# Non Functional Testing With JMeter Profiling

_1. This guide is the outcome of a Spike that is intended to gain knowledge on how to set up JMeter tests on a small Java-program.
a) The program can be the smallest Java-possible application but should contain a main function.
b) In this guide the Triangle program is used and the IDE is IntelliJ._

[![https://gyazo.com/17a28d9089a05644e350970fe8a6b421](https://i.gyazo.com/17a28d9089a05644e350970fe8a6b421.png)](https://gyazo.com/17a28d9089a05644e350970fe8a6b421)



Profiling is specifically dealing with the right bottom half side of the Agile Testing Quadrant.
It's about tests that are more
 internal to the team but equally important to the success of the software product. Profiling is all about 
 testing non functional requirements which are equally important to ensure a high quality product and user satisfaction.


*Load testing, implemented properly and performed throughout the development cycle, 
can significantly reduce the number of failures experienced by an application. 
Performance related issues in production affect the revenue the application generates and 
it is also very expensive to fix! Performance testing is not just done to measure overall 
the response time of the application and but also to understand the behavior of the system with other applications in the system!*

*There are many types / strategy of load testing, each of which simulate different load on the application. 
Each strategy helps us to identify different types of problems in the application / infrastructure.* [Reference](http://www.testautomationguru.com/jmeter-how-to-execute-different-performance-test-strategies/)




### Guide - How To Install Jmeter (Windows/Mac)

This guide is based on these youtube tutorials: [How to install](https://www.youtube.com/watch?v=M-iAXz8vs48&list=PLhW3qG5bs-L-zox1h3eIL7CZh5zJmci4c) and
[How to use JMeter](https://www.youtube.com/watch?v=8loLHbhfyh0&list=PLhW3qG5bs-L-zox1h3eIL7CZh5zJmci4c&index=1).

_Prerequisite_ 

Start by checking Java version. Version 6 or higher is required.

```java -version```

A. Download the JMeter as Binaries zip from [here](https://jmeter.apache.org/download_jmeter.cgi).

B. Unzip and keep Jmeter folder at any location on your machine.

C. Start JMeter

Windows: Go to the bin folder in the extracted folders and double click on jmeter.bat

Mac run the jmeter.sh


### Set Up A JMeter Test On The Triangle Program

To be able to run JMeter test on the Triangle program:

A. Create a Jar file of the Java-program. In [this video](https://www.youtube.com/watch?v=3Xo6zSBgdgk
) there is a guide on how to create a Jar from a Java program in IntelliJ.

B. Go to the Jmeter program and select new and a new Test plan is created.

C. In the Test Plan select the Jar file under browse:


[![https://gyazo.com/8d0f7ceab00178d4480bbafa544ad3bc](https://i.gyazo.com/8d0f7ceab00178d4480bbafa544ad3bc.png)](https://gyazo.com/8d0f7ceab00178d4480bbafa544ad3bc)


D. Select a Test Group:

[![https://gyazo.com/82b8a1293081182a78c8922716157634](https://i.gyazo.com/82b8a1293081182a78c8922716157634.png)](https://gyazo.com/82b8a1293081182a78c8922716157634)


E. Modify number of simulated users:

[![https://gyazo.com/d3eabe8edc53dec03d11006cb56f91d0](https://i.gyazo.com/d3eabe8edc53dec03d11006cb56f91d0.png)](https://gyazo.com/d3eabe8edc53dec03d11006cb56f91d0)

_Here I simulate 10 users over a period of 10 seconds, looped one time._


F. Select Sampler on the Thread Group:

[![https://gyazo.com/1b08a56f9424bfaab0dabb520892482c](https://i.gyazo.com/1b08a56f9424bfaab0dabb520892482c.png)](https://gyazo.com/1b08a56f9424bfaab0dabb520892482c)


_Bean Shell Sampler should be used because we are testing on the Jar-file._

G. Put the code in the scripts field to run the Java-program. In this case he Triangle-program:

```
import main.Triangle_exercise;

Triangle_exercise.main(new String[]{""});

```
[![https://gyazo.com/242ceadaf267f63bcb8d1b5bac58f496](https://i.gyazo.com/242ceadaf267f63bcb8d1b5bac58f496.png)](https://gyazo.com/242ceadaf267f63bcb8d1b5bac58f496)


H. Also add a listener that records the results from the tests:

[![https://gyazo.com/fd6504d837407c4e1a4d96bf26d6406a](https://i.gyazo.com/fd6504d837407c4e1a4d96bf26d6406a.png)](https://gyazo.com/fd6504d837407c4e1a4d96bf26d6406a)

I. Press the green play button to start the tests.

### Results From The Triangle Program Tests

[![https://gyazo.com/27cbea39e8e43e42f7f7cd4d40801b4d](https://i.gyazo.com/27cbea39e8e43e42f7f7cd4d40801b4d.png)](https://gyazo.com/27cbea39e8e43e42f7f7cd4d40801b4d)

As can be seen the first thread has a amazing upstart of 83 sec while the other threads runs in just a few milliseconds.
The reason for this could be that the first thread starts up and and triggers compilation of the program. 
The rest of the threads low times could be caused by Java Compilers ability to cash certain executions.

### Tests With HTTP Request Sampler

This examples demonstrates how easy it is to set up a JMeter test on HTTP Request. In this test GET requests are made to www.jetbrains.com.
In our Gutenberg project we are implementing a REST API so this kinds of test are interesting to us.


[![https://gyazo.com/ef462d15cd75a35197b38e5f5f07e685](https://i.gyazo.com/ef462d15cd75a35197b38e5f5f07e685.png)](https://gyazo.com/ef462d15cd75a35197b38e5f5f07e685)

[![https://gyazo.com/88daf802ee2d551af2dd4e0ed7eb1bf5](https://i.gyazo.com/88daf802ee2d551af2dd4e0ed7eb1bf5.png)](https://gyazo.com/88daf802ee2d551af2dd4e0ed7eb1bf5)

In the HTTP Request Sampler results we are especially interested in the Load time and Latency times. Latency time is the time to when the first byte is received.
Normal is around 500 milliseconds. 

### INCLUDING JMETER IN OUR GUTENBERG TEST STRATEGY

Our Gutenberg program consists of a AngularJS Application on the client side and Java REST API in the backend.

With this Spike we could say that we have gained knowledge on how to test a Java-application very low level directly on the application level using a Jar-file.

We have also gained knowledge how to test the application on the REST API level. We will preferably only test on the REST API level with the HTTP Request Sampler.
Becuase the Angular Application is using the REST API there is no reason to perform the test on a higher abstraction (the GUI).

_We have identified three possible test strategies for the Gutenberg project where we like to include JMeter:_

1) Stress Test

Performed to analyze the characteristics of the application under extreme load. 
Examines if the system is able to recover if load is reduced back to normal.

2) Soak test 

Performed to maintain a steady state with specific number of users continuously for few days – uncovers any memory / connection leaks.



3) Continuous Integration

Running CI processes load tests to get complete picture of the quality of the software. 
JMeter can be used to perform tests within continuous integration environments, there are many examples with this using Jenkins.
We are planning to use Travis for our continuous integration environments [this project](https://github.com/itaymendel/travis-jmeter) seems to 
give hope that it can be possible to integrate.


[Referece Source](http://www.testautomationguru.com/jmeter-how-to-execute-different-performance-test-strategies/)
