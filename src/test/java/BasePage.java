import org.openqa.selenium.WebDriver;


/**
 * Created by podde on 01.07.2017.
 */
public class BasePage extends ConciseAPI {
    private WebDriver driver;
    @Override
    public WebDriver getWebDriver() {
        return driver;
    }
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
