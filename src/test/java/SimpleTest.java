import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by podde on 29.06.2017.
 */
public class SimpleTest extends Assert {
    @Test
    public void navigateWedSiteSerchIPhone() {
        System.setProperty("webdriver.chrome.driver", "C://Users/podde/IdeaProjects/_testApp/src/test/chromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com.ua");
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.clear();
        searchField.sendKeys("automation");
        WebElement searchButton = driver.findElement(By.id("_fZl"));
        searchButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".r>a"))).click();
        assertTrue(driver.getTitle().toLowerCase().contains("automation"));
    }
    @Test
    public void googleExpectedDomain() {
        System.setProperty("webdriver.chrome.driver", "C://Users/podde/IdeaProjects/_testApp/src/test/chromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.clear();
        searchField.sendKeys("automation");
        WebElement searchButton = driver.findElement(By.id("_fZl"));
        searchButton.click();
        int pages = 5;
        for (int i = 0; i < pages; i++) {
            WebElement dynamicElement = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".navend")));
            WebElement nextPage = driver.findElement(By.cssSelector(".navend>a"));
            nextPage.click();
        }

    }
}
