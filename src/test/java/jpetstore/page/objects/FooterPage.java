package jpetstore.page.objects;

import io.qameta.allure.Step;
import jpetstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends BasePage{

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLoginLogo;

    @Step("Getting is dog banner is displayed")
    public boolean isBannerAfterLoginDisplayed(){
        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo);
        boolean isDisplayed = bannerAfterLoginLogo.isDisplayed();
        log().info("Returning status of banner after login: {}", isDisplayed);
        return isDisplayed;
    }
}
