package pierwszyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class FluentWaitTests {

    WebDriver driver;

    @BeforeMethod
        public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
    }

/*    @Test
        public void fluentWaitTest(){
        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        WebElement hiddenWord = driver.findElement(By.cssSelector("#finish h4"));

        assertFalse(hiddenWord.isDisplayed());

        startButton.click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .until(ExpectedConditions.visibilityOf(hiddenWord));

        assertTrue(hiddenWord.isDisplayed());
    }*/

    @AfterMethod
        public void afterTest(){
        driver.close();
        driver.quit();
    }
}
