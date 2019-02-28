package pierwszyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {

    public WebDriverWait webDriverWait;

    public WaitUntil(WebDriver driver){
        webDriverWait = new WebDriverWait(driver, 15);
    }

    public WebElement waitUntilPresenceOfElementLocated(By by){
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitElementIsInvisible(WebElement checkboxBeforeClick){
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkboxBeforeClick));
    }
}
