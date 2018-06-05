import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author Cherry Rose Semeña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumCarTest {

    private WebDriver driver;
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/home/cjs/Desktop/TEST_EXAM Materials/TEST_Assignments_1Sem2018/drivers/chromedriver");
        com.jayway.restassured.RestAssured.given().get("http://localhost:3000/reset");
        driver = new ChromeDriver();
        driver.get("http://localhost:3000");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
//        driver.quit();
        driver.close();
    }

    @Test
    public void test_1() {
        WebElement table = driver.findElement(By.id("tbodycars"));
        List<WebElement> cars = table.findElements(By.tagName("tr"));
        assertThat(cars.size(), is(5));
    }

    @Test
    public void test_2(){
        WebElement filter = driver.findElement(By.id("filter"));
        filter.sendKeys("2002");
        WebElement table = driver.findElement(By.id("tbodycars"));
        List<WebElement> cars = table.findElements(By.tagName("tr"));
        assertThat(cars.size(), is(2));
    }

    @Test
    public void test_3(){
        driver.findElement(By.id("filter")).sendKeys("2002");;
        driver.findElement(By.id("filter")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
        WebElement table = driver.findElement(By.id("tbodycars"));
        List<WebElement> cars = table.findElements(By.tagName("tr"));
        assertThat(cars.size(), is(5));
    }

    @Test
    public void test_4() throws InterruptedException {
        WebElement sortYear = driver.findElement(By.id("h_year"));
        sortYear.click();
        WebElement table = driver.findElement(By.id("tbodycars"));
        List<WebElement> cars = table.findElements(By.tagName("tr"));

        WebElement first = cars.get(0);
        WebElement last = cars.get(cars.size()-1);
        List<WebElement> tData = first.findElements(By.tagName("td"));
        assertThat(tData.get(0).getText(), is("938"));
        tData = last.findElements(By.tagName("td"));
        assertThat(tData.get(0).getText(), is("940"));
    }

    @Test
    public void test_5(){
        WebElement table = driver.findElement(By.id("tbodycars"));
        List<WebElement> cars = table.findElements(By.tagName("tr"));
        WebElement firstCar = cars.get(0);
        firstCar.findElements(By.tagName("a")).get(0).click();
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("Cool car");
        driver.findElement(By.id("save")).click();
        List<WebElement> tData = firstCar.findElements(By.tagName("td"));
        assertThat(tData.get(5).getText(), is("Cool car"));
    }

    @Test
    public void test_6(){
        driver.findElement(By.id("new")).click();
        driver.findElement(By.id("save")).click();
        WebElement error = driver.findElement(By.id("submiterr"));
        assertThat(error.getText(), is("All fields are required"));
    }
    
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

}