package pierwszyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertTrue;

public class SeleniumGridExampleTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), capability);
    }

    @Test
    public void searchQueryInGoogle() {
        driver.navigate().to("http://google.pl");

        driver.findElement(By.name("q")).sendKeys("JavaStart");
        driver.findElement(By.name("q")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
