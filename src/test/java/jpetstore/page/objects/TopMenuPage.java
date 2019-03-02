package jpetstore.page.objects;

import io.qameta.allure.Step;
import jpetstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage{

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignInLink(){
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        log().info("Clicked on Sign on Link");
        return new LoginPage();
    }
}
