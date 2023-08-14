import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginTest {
    private WebDriver driver;
    private loginPage loginPage;
    private Properties prop;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ifrah.asif\\\\IdeaProjects\\\\chromedriver_win32\\\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new loginPage(driver);
        prop = new Properties();

        try {
            FileInputStream configFile = new FileInputStream("src/test/java/config.properties");
            prop.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.get(prop.getProperty("app.url"));
    }

    @Test
    public void testValidLogin() {
        String username = prop.getProperty("login.username");
        String password = prop.getProperty("login.password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
