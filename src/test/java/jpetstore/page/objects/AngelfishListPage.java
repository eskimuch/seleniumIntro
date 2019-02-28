package jpetstore.page.objects;

import jpetstore.driver.manager.DriverManager;
import jpetstore.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelfishListPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='workingItemId=EST-2']")
    private WebElement addToCartSmallAngelfishButton;

    public AngelfishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ShoppingCartPage clickOnAddToCartSmallAngelfish(){
        WaitForElement.waitUntilElementIsClickable(addToCartSmallAngelfishButton);
        addToCartSmallAngelfishButton.click();
        logger.info("Clicked on add small Angelfish to cart button ");
        return new ShoppingCartPage();
    }
}
