import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by podde on 01.07.2017.
 */
public class BaseTest extends ConciseAPI {
    static WebDriver driver = null;

    @BeforeClass
    public static void createAndStartService() {
        System.setProperty("webdriver.chrome.driver", "C://Users/podde/IdeaProjects/_testApp/src/test/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Override
    public WebDriver getWebDriver(){
        return driver;
    }

    @AfterClass
    public static void closeChrome()
    {
        driver.quit();
    }

}
