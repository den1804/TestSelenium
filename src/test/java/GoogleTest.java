import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by podde on 30.06.2017.
 */
public class GoogleTest extends BaseTest {

    GooglePage page = new GooglePage(driver);
    @Test
    public void testSearchText() {
        page.visit();

        page.searchMore("Selenium");
        assertThat(textToBePresentInElementLocated(page.firstResult, "Selenium is a suite"));

        page.searchMore(" chemical element");
        assertThat(textToBePresentInElementLocated(page.firstResult, "Selenium is a chemical element"));
    }
    @Test
    public void testFollowFirstResult() {
        page.visit();
        page.searchMore("selenium");
        page.followFirstResult();
        assertThat(titleIs("Selenium - Web Browser Automation"));
    }
    @Test
    public void testNextPage() {
        page.visit();
        page.searchMore("automation");
        page.followNextPage();
        for (int i = 0; i < 5; i++) {

        }
    }
    @Test
    public void test()
    {
        page.visit();
        page.searchMore("automation");
        for (int i = 0; i < 5; i++) {
            (new WebDriverWait(driver, 4)).until(
                    textToBePresentInElement(page.nextPage, "Next"));
            page.nextPage.click();
        }
    }
}
