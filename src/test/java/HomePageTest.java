import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriverr.chrome.driver","C:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void testLoginWithValidCreds() {
        driver.get("https://qaebank.ccbp.tech/ebank/login");

        WebElement userID = driver.findElement(By.id("userIdInput"));
        userID.sendKeys("142420");

        WebElement pinInputEl = driver.findElement(By.id("pinInput"));
        pinInputEl.sendKeys("231225");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/"));

        String expectedURl = "https://qaebank.ccbp.tech/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURl, actualURL, "URLs do not match");

        WebElement headingEl = driver.findElement(By.className("heading"));
        String expectedHeading = headingEl.getText();
        String actualHeading = "Your Flexibility, Our Excellence";

        Assert.assertEquals(expectedHeading,actualHeading,"Heading text does not match");

    }

    @Test
    public void testLogoutFunctionality(){
        driver.get("https://qaebank.ccbp.tech/ebank/login");

        WebElement userID = driver.findElement(By.id("userIdInput"));
        userID.sendKeys("142420");

        WebElement pinInputEl = driver.findElement(By.id("pinInput"));
        pinInputEl.sendKeys("231225");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qaebank.ccbp.tech/"));

        String expectedURl = "https://qaebank.ccbp.tech/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURl, actualURL, "URLs do not match");

        WebElement logoutButton = driver.findElement(By.className("logout-button"));
       logoutButton.click();
        String expectedLogoutURL = "https://qaebank.ccbp.tech/ebank/login";
        String actualLogoutURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedLogoutURL,actualLogoutURL,"URLs do not match");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

