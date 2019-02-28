package pierwszyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.*;

public class WebElementsTests {

    private WebDriver driver;

    @BeforeMethod
        public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
        public void typingIntoWebElementTest(){
        WebElement userNameFiled = driver.findElement(By.id("username"));
        userNameFiled.sendKeys("Selenium Start");
        String typeUserNameValue = userNameFiled.getAttribute("value");
        assertEquals(typeUserNameValue, "Selenium Start");
    }

    @Test
        public void filePickingTest(){
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("C:\\Users\\eskim\\OneDrive\\Pulpit\\do usuniecia");
    }

    @Test
        public void typingAndClearingValueInsideWebElementTest(){
        WebElement userNamefiled = driver.findElement(By.id("username"));
        sleep();
        userNamefiled.sendKeys("Selenium Start");
        String typeUserNameValue = userNamefiled.getAttribute("value");
        sleep();
        assertEquals(typeUserNameValue, "Selenium Start");

        userNamefiled.clear();
        sleep();

        String emptyUserNameField = userNamefiled.getAttribute("value");
        assertEquals(emptyUserNameField, "");
    }

    @Test
        public void checkRadioButtonTest(){
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

        sleep();
        maleRadioButton.click();
        sleep();
        assertTrue(maleRadioButton.isSelected());

        femaleRadioButton.click();
        sleep();
        assertTrue(femaleRadioButton.isSelected());
        assertFalse(maleRadioButton.isSelected());
    }

    @Test
        public void checkboxButtonTest(){
        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger']"));

        sleep();
        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        assertTrue(pizzaCheckbox.isSelected());
        assertTrue(spaghettiCheckbox.isSelected());
        assertTrue(hamburgerCheckbox.isSelected());
        sleep();

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        sleep();
        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());
    }

    @Test
        public void dropDownListingTest(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        List<WebElement> options = countryDropDown.getOptions();
        List<String> namesOfOptions = new ArrayList<String>();

        for (WebElement option:options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }

        List<String> expectedNamesOfOptions = new ArrayList<String>();
        expectedNamesOfOptions.add("Germany");
        expectedNamesOfOptions.add("Poland");
        expectedNamesOfOptions.add("UK");

        assertEquals(namesOfOptions, expectedNamesOfOptions);
    }

    @Test
        public void selectingOptionsFromDropDownTest(){
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);
        countryDropDown.selectByIndex(1);
        assertEquals(countryDropDown.getFirstSelectedOption().getText(),"Poland");
        countryDropDown.selectByValue("de_DE");
        assertEquals(countryDropDown.getFirstSelectedOption().getText(),"Germany");
        countryDropDown.selectByVisibleText("UK");
        assertEquals(countryDropDown.getFirstSelectedOption().getText(),"UK");
    }

    @Test
        public void checkIfElementsOnPageTest(){
        WebElement userNameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.className("help-block"));

        System.out.println("Is userNameField displayed: " + userNameField.isDisplayed());
        System.out.println("Is usernameField enabled: " + userNameField.isEnabled());

        System.out.println("Is passwordField displayed: " + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled: " + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed: " + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled: " + emailLabel.isEnabled());

        assertTrue(userNameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());

        assertTrue(userNameField.isEnabled());
        assertFalse(passwordField.isEnabled());
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        @AfterMethod
        public void afterTest(){
        driver.close();
        driver.quit();
    }
}
