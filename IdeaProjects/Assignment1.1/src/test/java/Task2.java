import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task2 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void FormFilling() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");

        // By ID Locator
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("hello");
        // By Name Attribute Locator
        WebElement lastNameField = driver.findElement(By.name("lastname"));
        lastNameField.sendKeys("john");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("ifrahasif333@gmail.com");
        // By Xpath Locator
        WebElement telephoneInput = driver.findElement(By.xpath("//input[@placeholder='Telephone']"));
        telephoneInput.sendKeys("1234567890");

        // By HTML tag name locator
         WebElement passwordInput = driver.findElement(By.cssSelector("input#input-password"));
        passwordInput.sendKeys("securepassword");

        WebElement ConfirmPasswordInput = driver.findElement(By.xpath("//input[contains(@id, 'input-confirm') and @type='password']"));
        ConfirmPasswordInput.sendKeys("securepassword");

        /*  WebElement radioCheckbox = driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter']"));
         */
        WebElement noOptionCheckbox = driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter' and @value='0' and @checked='checked']"));
        noOptionCheckbox.click(); // This will uncheck the "No" option


        WebElement Agree = driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree' and @value='1']"));
        Agree.click(); // This will check agree option

        // Submit the form
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']"));
        continueButton.click();

        driver.quit();
/*
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

 */
    }
}
