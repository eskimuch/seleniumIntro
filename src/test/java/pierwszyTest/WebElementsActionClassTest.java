package pierwszyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WebElementsActionClassTest {

    private WebDriver driver;
    public static final String SMILE_ICON_1_EXPECTED_SIZE = "(32, 32)";
    public static final String SMILE_ICON_2_EXPECTED_SIZE = "(64, 64)";


    @BeforeMethod
        public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
    }

    @Test
        public void hoverOverSmileyIconsTest(){
        WebElement smileyIcon1 = driver.findElement(By.id("smiley"));
        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));

        Actions action = new Actions(driver);
        action.moveToElement(smileyIcon1).moveToElement(smileyIcon2).build().perform();

        String smileIcon1Size = smileyIcon1.getSize().toString();
        assertEquals(smileIcon1Size,SMILE_ICON_1_EXPECTED_SIZE);
        String smileIcon2Size = smileyIcon2.getSize().toString();
        assertEquals(smileIcon2Size,SMILE_ICON_2_EXPECTED_SIZE);
    }

    @AfterMethod
        public void afterTest(){
        driver.close();
        driver.quit();
    }
}
