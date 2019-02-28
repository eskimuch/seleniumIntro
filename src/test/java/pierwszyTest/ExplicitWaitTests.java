package pierwszyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class ExplicitWaitTests {

    WebDriver driver;

    @BeforeMethod
        public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
        public void waitForDisappearingElement(){
        WebElement aCheckbox = driver.findElement(By.cssSelector("input[id='checkbox']"));

        assertTrue(aCheckbox.isDisplayed());
        assertFalse(aCheckbox.isSelected());

        WebElement removeOrAddButton = driver.findElement(By.cssSelector("[id='btn']"));
        removeOrAddButton.click();

        WaitUntil waitUntil = new WaitUntil(driver);
        waitUntil.waitElementIsInvisible(aCheckbox);

        WebElement buttonMessage = driver.findElement(By.cssSelector("[id='message']"));
        assertEquals(buttonMessage.getText(),"It's gone!");

        removeOrAddButton.click();

        aCheckbox = waitUntil.waitUntilPresenceOfElementLocated(By.cssSelector("input[id='checkbox']"));

        assertTrue(aCheckbox.isDisplayed());
        assertFalse(aCheckbox.isSelected());
    }

    @AfterMethod
        public void afterTest(){
        driver.close();
        driver.quit();
    }
}
