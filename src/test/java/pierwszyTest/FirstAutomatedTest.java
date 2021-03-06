package pierwszyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirstAutomatedTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://google.pl");

        WebElement queryField = driver.findElement(By.name("q"));
        queryField.sendKeys("Kocham robaka");
        queryField.submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("Kocham robaka"));
    }

    @Test
    public void mySecondTest(){
        driver.navigate().to("http://www.seleniumhq.org/");

        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.equals("Selenium - Web Browser Automation"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}