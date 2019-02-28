package jpetstore.page.objects;

import jpetstore.driver.manager.DriverManager;
import jpetstore.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='productId=FI-SW-01']")
    private WebElement angelFishProductId;

    public FishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public AngelfishListPage clickOnAngelFishId(){
        WaitForElement.waitUntilElementIsClickable(angelFishProductId);
        angelFishProductId.click();
        logger.info("Clicked on Angelfish link");
        return new AngelfishListPage();
    }
}
