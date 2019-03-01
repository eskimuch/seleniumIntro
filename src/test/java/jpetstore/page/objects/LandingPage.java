package jpetstore.page.objects;

import io.qameta.allure.Step;
import jpetstore.driver.manager.DriverManager;
import jpetstore.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy (css = "#Content a")
    private WebElement enterStoreLink;

    public LandingPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on Enter Store link")
    public TopMenuPage clickOnEnterStoreLink(){
        WaitForElement.waitUntilElementIsClickable(enterStoreLink);
        enterStoreLink.click();
        logger.info("Clicked on Enter Store link");
        return new TopMenuPage();
    }

}
