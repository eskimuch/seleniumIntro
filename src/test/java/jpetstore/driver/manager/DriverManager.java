package jpetstore.driver.manager;

import jpetstore.configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;

import static jpetstore.configuration.TestRunProperties.getBrowserToRun;
import static jpetstore.configuration.TestRunProperties.getIsRemoteRun;
import static jpetstore.driver.manager.BrowserType.FIREFOX;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public DriverManager() {
    }

    public static WebDriver getWebDriver(){
        if(webDriverThreadLocal.get() == null){
            webDriverThreadLocal.set(new BrowserFactory(getBrowserToRun(),getIsRemoteRun()).getBrowser());
        }

        return webDriverThreadLocal.get();
    }

    public static void disposeDriver(){
        webDriverThreadLocal.get().close();
        if (!getBrowserToRun().equals(FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
    }
}
