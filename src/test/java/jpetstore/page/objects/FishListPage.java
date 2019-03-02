package jpetstore.page.objects;

import jpetstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FishListPage extends BasePage{

    @FindBy(css = "a[href*='productId=FI-SW-01']")
    private WebElement angelFishProductId;

    public AngelfishListPage clickOnAngelFishId(){
        WaitForElement.waitUntilElementIsClickable(angelFishProductId);
        angelFishProductId.click();
        log().info("Clicked on Angelfish link");
        return new AngelfishListPage();
    }
}
