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

public class LoginPageTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriverr.chrome.driver","C:\\Users\\hi\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Test(priority = 1)
    public void testLoginWithEmptyInputs(){
        driver.get("https://qaebank.ccbp.tech/ebank/login");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));

        String expectedMsg = errorMsg.getText();
        String actualMsg = "Invalid user ID";

        Assert.assertEquals(expectedMsg,actualMsg,"Error text with empty input fields does not match");
    }
    @Test(priority = 2)
    public void testLoginWithEmptyUserId(){
        driver.get("https://qaebank.ccbp.tech/ebank/login");

        WebElement pinInputEl = driver.findElement(By.id("pinInput"));
        pinInputEl.sendKeys("231225");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));

        String expectedMsg = errorMsg.getText();
        String actualMsg = "Invalid user ID";

        Assert.assertEquals(expectedMsg,actualMsg,"Error text with empty input field do not match");

    }

    @Test(priority = 3)
    public void testLoginWithEmptyPin(){
        driver.get("https://qaebank.ccbp.tech/ebank/login");

        WebElement userID = driver.findElement(By.id("userIdInput"));
        userID.sendKeys("142420");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));

        String expectedMsg = errorMsg.getText();
        String actualMsg = "Invalid PIN";

        Assert.assertEquals(expectedMsg,actualMsg,"Error text with empty input field do not match");
    }
    @Test(priority = 4)
    public void testLoginWithInvalidCreds(){

        driver.get("https://qaebank.ccbp.tech/ebank/login");

        WebElement userID = driver.findElement(By.id("userIdInput"));
        userID.sendKeys("142420");

        WebElement pinInputEl = driver.findElement(By.id("pinInput"));
        pinInputEl.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));

        String expectedMsg = errorMsg.getText();
        String actualMsg = "User ID and PIN didn't match";

        Assert.assertEquals(expectedMsg,actualMsg,"Error text with invalid pin do not match");

    }
    @Test(priority = 5)
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
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
