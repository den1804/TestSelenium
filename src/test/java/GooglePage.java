import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by podde on 01.07.2017.
 */
public class GooglePage extends BasePage {

    By firstResult = byCss(".srg .g:nth-child(1)");
    @FindBy(css = "#foot .pn")
    WebElement nextPage;


    public void visit() { open("https://google.com/ncr"); }

    public void searchMore(String text) {
        $(By.name("q")).sendKeys(text, Keys.ENTER);
    }

    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void followFirstResult() {
        $(firstResult).findElement(byCss(".r a")).click();
    }
    public void followNextPage() {
        $(firstResult).findElement(byCss("#foot .pn")).click();
    }

}