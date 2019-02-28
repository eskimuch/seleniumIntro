package jpetstore.page.objects;

import jpetstore.driver.manager.DriverManager;
import jpetstore.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*=newOrderForm]")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public CheckoutPage clickOnProceedToCheckoutButton(){
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked on 'Proceed to Checkout' button");
        return new CheckoutPage();
    }
}
