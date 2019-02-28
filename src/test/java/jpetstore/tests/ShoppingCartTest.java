package jpetstore.tests;

import jpetstore.page.objects.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ShoppingCartTest  extends TestBase{

    @Test
    public void asNotLoginUserTryToProceedToCheckout(){
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
        loginPage
                .clickOnTopFishImageButton()
                .clickOnAngelFishId()
                .clickOnAddToCartSmallAngelfish()
                .clickOnProceedToCheckoutButton();

        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage, "You must sign on before attempting to check out. Please sign on and try checking out again." );
    }
}
