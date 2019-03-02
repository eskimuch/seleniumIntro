package jpetstore.page.objects;

import jpetstore.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    @FindBy(css = "a[href*=newOrderForm]")
    private WebElement proceedToCheckoutButton;

    public CheckoutPage clickOnProceedToCheckoutButton(){
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Clicked on 'Proceed to Checkout' button");
        return new CheckoutPage();
    }
}
