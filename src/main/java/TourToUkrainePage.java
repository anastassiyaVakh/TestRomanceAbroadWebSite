import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TourToUkrainePage extends BaseActions {

    public TourToUkrainePage(WebDriver driver, WebDriverWait wait){
        super( driver,wait);
    }

    public void toursSearchTest(){
        driver.findElement(Locators.SEARCH_FIELD_PRODUCT).sendKeys (Data.searchProduct);
        driver.findElement(Locators.BUTTON_SEARCH_PRODUCT).click ();

    }
}
