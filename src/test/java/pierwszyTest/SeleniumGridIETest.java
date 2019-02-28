package pierwszyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridIETest {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.enablePersistentHovering();
        internetExplorerOptions.ignoreZoomSettings();
        internetExplorerOptions.setCapability("version","8");

        driver = new RemoteWebDriver(new URL("http:/192.168.1.4:4444/wd/hub"),internetExplorerOptions);
    }

}
