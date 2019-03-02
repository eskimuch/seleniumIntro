package jpetstore.page.objects;

import jpetstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AngelfishListPage extends BasePage{

    @FindBy(css = "a[href*='workingItemId=EST-2']")
    private WebElement addToCartSmallAngelfishButton;

    public ShoppingCartPage clickOnAddToCartSmallAngelfish(){
        WaitForElement.waitUntilElementIsClickable(addToCartSmallAngelfishButton);
        addToCartSmallAngelfishButton.click();
        log().info("Clicked on add small Angelfish to cart button ");
        return new ShoppingCartPage();
    }
}
