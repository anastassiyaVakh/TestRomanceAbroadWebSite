import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftsPage extends BaseActions {

    public GiftsPage(WebDriver driver, WebDriverWait wait){
        super( driver,wait);
    }

    public void giftsSearchTest(){
        driver.findElement(Locators.SEARCH_FIELD_PRODUCT).sendKeys (Data.gift);
        driver.findElement (Locators.BUTTON_SEARCH_PRODUCT).click ();
        driver.findElement (Locators.LINK_TEDDY_BEARS).click ();
        scrollToBottomOfPage ();
        driver.findElement (Locators.LINK_FLOWER_BASKET).click ();
    }
}
