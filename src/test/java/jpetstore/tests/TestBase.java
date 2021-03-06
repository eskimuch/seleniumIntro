package jpetstore.tests;

import io.qameta.allure.Step;
import jpetstore.configuration.ConfigurationProperties;
import jpetstore.configuration.PropertiesLoader;
import jpetstore.driver.manager.BrowserType;
import jpetstore.driver.manager.DriverManager;
import jpetstore.driver.manager.DriverUtils;
import org.testng.annotations.*;

import java.util.Properties;

import static jpetstore.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @Step("Loading configuration from configuration.properties")
    @BeforeClass
    public void beforeClass(){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Setting up browser type and navigating to Home Page")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType){
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest(){
        DriverManager.disposeDriver();
    }
}
