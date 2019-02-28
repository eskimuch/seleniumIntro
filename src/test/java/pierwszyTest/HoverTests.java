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

public class HoverTests {

    WebDriver driver;

    @BeforeMethod
        public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
        public void hoverTest(){
        WebElement firstUserIcon = driver.findElement(By.xpath("//div[@class='example']/div[1]/img"));
        WebElement secondUserIcon = driver.findElement(By.xpath("//div[@class='example']/div[2]/img"));
        WebElement thirdUserIcon = driver.findElement(By.xpath("//div[@class='example']/div[3]/img"));
        WebElement firstUserIconFooter = driver.findElement(By.xpath("//div[1]/div/h5"));
        WebElement secondUserIconFooter = driver.findElement(By.xpath("//div[2]/div/h5"));
        WebElement thirdUserIconFooter = driver.findElement(By.xpath("//div[3]/div/h5"));

        Actions action = new Actions(driver);
        action.moveToElement(firstUserIcon).perform();

        assertEquals(firstUserIconFooter.getText(),"name: user1");
        assertEquals(secondUserIconFooter.getText(),"");
        assertEquals(thirdUserIconFooter.getText(),"");

        action.moveToElement(secondUserIcon).perform();

        assertEquals(firstUserIconFooter.getText(),"");
        assertEquals(secondUserIconFooter.getText(),"name: user2");
        assertEquals(thirdUserIconFooter.getText(),"");

        action.moveToElement(thirdUserIcon).perform();

        assertEquals(firstUserIconFooter.getText(),"");
        assertEquals(secondUserIconFooter.getText(),"");
        assertEquals(thirdUserIconFooter.getText(),"name: user3");
    }

    @AfterMethod
        public void afterTest(){
        driver.close();
        driver.quit();
    }
}
