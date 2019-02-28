package jpetstore.driver.manager;

import jpetstore.configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;

import static jpetstore.configuration.TestRunProperties.getBrowserToRun;
import static jpetstore.configuration.TestRunProperties.getIsRemoteRun;
import static jpetstore.driver.manager.BrowserType.FIREFOX;

public class DriverManager {

    private static WebDriver driver;

    public DriverManager() {
    }

    public static WebDriver getWebDriver(){
        if(driver == null){
            driver = new BrowserFactory(getBrowserToRun(),getIsRemoteRun()).getBrowser();
        }

        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        if (!getBrowserToRun().equals(FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}
