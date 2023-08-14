import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\ifrah.asif\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        //WebDriverManager.chromedriver().setup(); // Use WebDriverManager to set up ChromeDriver
        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();
        // Add specific options and arguments
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options); // Initialize the class-level driver variable
    }

    @Test
    public void googleSearch() {
        driver.get("https://www.google.com");
        // Perform Google search actions here
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
