import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BaseActions {

    public SearchPage(WebDriver driver, WebDriverWait wait){
        super( driver,wait);
    }

  public void searchForWomenTest(){
      WebElement dropDownListSortByMinAge = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY_MIN_AGE);
      getDropDownListByIndex(dropDownListSortByMinAge, 30);

      WebElement dropDownListSortByMaxAge = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY_MAX_AGE);
      getDropDownListByIndex(dropDownListSortByMaxAge, 40);
      driver.findElement(Locators.BUTTON_SEARCH).click();

      WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY);
      getDropDownListByIndex(dropDownListSortBy,3);
      driver.findElement(Locators.PROFILE).click();

  }
}
