package pierwszyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CheckBoxesTests {

    WebDriver driver;

    @BeforeMethod
        public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
    }

    @Test
        public void checkboxesTest(){
        WebElement firstCheckbox = driver.findElement(By.cssSelector("#checkboxes :first-child"));
        WebElement secondCheckbox = driver.findElement(By.cssSelector("#checkboxes :last-child"));

        assertFalse(firstCheckbox.isSelected());
        assertTrue(secondCheckbox.isSelected());

        firstCheckbox.click();
        secondCheckbox.click();

        assertTrue(firstCheckbox.isSelected());
        assertFalse(secondCheckbox.isSelected());
    }

    @AfterMethod
        public void afterTest(){
        driver.close();
        driver.quit();
    }
}
