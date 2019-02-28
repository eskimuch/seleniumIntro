package jpetstore.page.objects;

import jpetstore.driver.manager.DriverManager;
import jpetstore.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Content ul.messages li")
    private WebElement messageLabel;

    @FindBy(css = "#QuickLinks img[src*='fish']")
    private WebElement fishTopImageButton;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public LoginPage typeIntoUserNameField(String username){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
        return this;
    }

    public FooterPage clickOnLoginButton(){
        signOnButton.click();
        logger.info("Clicked on Login Button");
        return new FooterPage();
    }

    public String getWarningMessage(){
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        logger.info("Returned warning message was: {}", warningText);
        return warningText;
    }

    public FishListPage  clickOnTopFishImageButton(){
        WaitForElement.waitUntilElementIsClickable(fishTopImageButton);
        fishTopImageButton.click();
        logger.info("Clicked on Fish Image Top Button");
        return new FishListPage();
    }
}
