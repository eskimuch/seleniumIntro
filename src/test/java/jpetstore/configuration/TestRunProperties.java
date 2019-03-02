package jpetstore.configuration;

import jpetstore.driver.manager.BrowserType;

public class TestRunProperties {

    public static BrowserType getBrowserToRun() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }
}
