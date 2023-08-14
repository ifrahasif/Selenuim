import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task4 {

  //  WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ifrah.asif\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to Google
        driver.get("https://www.google.com/");

        // Capture the initial URL
        String initialURL = driver.getCurrentUrl();

        // Validate title
        validateTitle(driver, "Google");

        // Validate URL
        validateURL(driver, "https://www.google.com/");

        // Perform search
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        // Validate search page title
        validateTitle(driver, "Selenium - Google Search");

        // Validate search results
        validateSearchResults(driver);

        // Open first search result
        WebElement firstResultLink = driver.findElement(By.cssSelector("div.tF2Cxc a"));
        firstResultLink.click();


        // Validate page load
        validateTitle(driver, "Selenium");

        // Validate page load
        validatePageLoad(driver);

        // Reload the page
        driver.navigate().refresh();

        // Navigate back to Google search home page using the initial URL
        driver.navigate().to(initialURL);

        // Validate navigation back
        validateURL(driver, initialURL);

    //    driver.quit();
    }

    private static void validateTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS: Title matched - " + expectedTitle);
        } else {
            System.out.println("FAIL: Title not matched. Expected: " + expectedTitle + " | Actual: " + actualTitle);
        }
    }

    private static void validateURL(WebDriver driver, String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals(expectedURL)) {
            System.out.println("PASS: URL matched - " + expectedURL);
        } else {
            System.out.println("FAIL: URL not matched. Expected: " + expectedURL + " | Actual: " + actualURL);
        }
    }

    private static void validateSearchResults(WebDriver driver) {
        String expectedTitle = "Selenium - Google Search";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS: Search page title matched - " + expectedTitle);
        } else {
            System.out.println("FAIL: Search page title not matched. Expected: " + expectedTitle + " | Actual: " + actualTitle);
        }

        int searchResultsCount = driver.findElements(By.cssSelector("div.tF2Cxc a")).size();
        if (searchResultsCount > 0) {
            System.out.println("PASS: Search results found - Count: " + searchResultsCount);
        } else {
            System.out.println("FAIL: No search results found.");
        }
    }
    private static void validatePageLoad(WebDriver driver) {
        String currentURL = driver.getCurrentUrl();
        if (!currentURL.isEmpty()) {
            System.out.println("PASS: Page loaded successfully - URL: " + currentURL);
        } else {
            System.out.println("FAIL: Page did not load successfully.");
        }
    }
}