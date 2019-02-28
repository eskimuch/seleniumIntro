package jpetstore.driver.manager;

import jpetstore.configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    public DriverManager() {
    }

    public static WebDriver getWebDriver(){
        if(driver == null){
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }

        return driver;
    }

    public static void disposeDriver(){
        driver.close();
        if (!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}
