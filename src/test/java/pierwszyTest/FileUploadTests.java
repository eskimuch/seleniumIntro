package pierwszyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class FileUploadTests {

    WebDriver driver;
    public static final String FILE_NAME = "testfile.txt";
    public static final String FILE_LOCATION = "C:\\Users\\eskim\\OneDrive\\Pulpit\\testfile.txt";

    @BeforeMethod
        public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
        public void fileUploadTest(){
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(FILE_LOCATION);

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement fileUploadedNameField = driver.findElement(By.id("uploaded-files"));
        assertEquals(fileUploadedNameField.getText(), FILE_NAME);
    }

/*    public void sleep()  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    @AfterMethod
        public void afterTest(){
        driver.close();
        driver.quit();
    }
}
