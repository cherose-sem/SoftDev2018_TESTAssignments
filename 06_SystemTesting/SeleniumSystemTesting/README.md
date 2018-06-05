### Automated System Testing with Selenium 2
> _Demonstrate your solution to the exercise "Automated System Testing with Selenium2"._

> Test Cases(Source): <br>
[SeleniumCarTest.java](https://github.com/cph-cs241/TEST_Assignments_1Sem2018/blob/master/SeleniumSystemTesting/src/test/java/SeleniumCarTest.java) <br>

> Test Result: <br>
![alt text](https://github.com/cph-cs241/TEST_Assignments_1Sem2018/blob/master/SeleniumSystemTesting/SeleniumTestResult.JPG)

_You should (as a minimum):_ <br>
 ● Discuss Pros and Cons with manual versus automated tests <br>
 ##### In Manual Testing:
 
 Pros | Cons 
 --- | --- 
 Short-term cost is lower | Certain tasks are difficult to do manually
 Consistent with Life Testing |  Not stimulating
 Manual testing is flexible | Can’t reuse manual tests

 ##### In Automated Testing: 
 
 Pros | Cons 
 --- | ---
 Runs tests quickly and effectively | Additional Cost Required
 Can be cost effective | Lack of Human Input on Usability and UI
 Everyone can see results | Tools’ limitations and In-Built Issues
 
 ● Explain about the Test Pyramid and whether this exercise supports the ideas in the Test Pyramid <br>
 
 The Test Pyramid has the essential point that you should havemany more low-level unit tests than high level end-to-end tests running through GUI. A test pyramid delivers a graphical representation of a best-case test scenario where you have a large number of low-level unit tests (around 70%) and comparatively few high level end-to-end system tests (about 10%), with an intermediate layer of integration tests sandwiched in between which adds up to around 20%. <br>
 
 In this exercise, I believe it clearly supports the ideas in the Test Pyramid. The unit test is tetsing the individual components wherein we did a couple of them in testing the car application's functionality. In the service layer, we do testing through an API layer while the UI part of the pyramid would correspond to test using Selenium.
 
 ● Discuss some of the problems with automated GUI tests and what makes such tests "vulnerable"  <br>
 
 Automated GUI tests is highly vulnnerable since it is the part where is often refactored. In that case, it would hard to do test automation as it might fail randomly. Some problems will inevitably arise, as your suite of tests grow, you will find they require more and more maintenance. Running the tests will require more and more time to just make it through the tests.
 
 ● Demonstrate details in how to create a Selenium Test using the code for the exercise <br>

_Selenium Testing:_
1. Create a WebDriver instance. <br>
``` System.setProperty("webdriver.chrome.driver","C:\\Users\\cherr\\Desktop\\SoftDev_1st\\TEST\\Assignments\\drivers\\chromedriver.exe");
driver = new ChromeDriver();
```

2. Navigate to a Web page. <br>
```
driver.get("http://localhost:3000");
```

3. Locate an HTML element on the Web page. <br>
```
WebElement table = driver.findElement(By.id("tbodycars"));
List<WebElement> cars = table.findElements(By.tagName("tr"));
WebElement firstCar = cars.get(0);
```

4. Perform an action on an HTML element. <br>
```
firstCar.findElements(By.tagName("a")).get(0).click();
driver.findElement(By.id("description")).clear();
driver.findElement(By.id("description")).sendKeys("Cool car");
driver.findElement(By.id("save")).click();
```

5. Anticipate the browser response to the action. <br>
```
assertThat(tData.get(5).getText(), is("Cool car"));
```

6. Run tests and record test results using a test framework. <br>
7. Conclude the test. <br>
 
See the complete tests [here](https://github.com/cph-cs241/TEST_Assignments_1Sem2018/blob/master/SeleniumSystemTesting/src/test/java/SeleniumCarTest.java). 
 
 ● Explain shortly about the DOM, and how you have read/manipulated DOM-elements in your test  <br>

The finder methods search the DOM (Document Object Model) tree for the web page, evaluating locator types for HTML elements, and comparing their values to the locator value. For example:
 ```
 @Test
    public void test_7(){
        List<WebElement> cars;
        driver.findElement(By.id("year")).sendKeys("2008");
        driver.findElement(By.id("registered")).sendKeys("2002-5-5");
        driver.findElement(By.id("make")).sendKeys("Kia");
        driver.findElement(By.id("model")).sendKeys("Rio");
        driver.findElement(By.id("description")).sendKeys("As new");
        driver.findElement(By.id("price")).sendKeys("31000");
        driver.findElement(By.id("save")).click();
        WebElement table = driver.findElement(By.id("tbodycars"));
        cars = table.findElements(By.tagName("tr"));
        assertThat(cars.size(), is(6));
    }
 ```
 
 ● Explain how (and why it was necessary) you have solved "waiting" problems in your test <br>
 
 Most of the web applications are developed using Ajax and Javascript. When a page is loaded by the browser the elements which we want to interact with may load at different time intervals. It simply make sure that everything is loaded and ready before the test has taken place.
  ```
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  ```
 
