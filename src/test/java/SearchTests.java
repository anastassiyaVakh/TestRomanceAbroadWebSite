import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseUI {

    String currentUrlSearch;
    String expectedUrlSearch = "https://romanceabroad.com/users/search";


    public void getDropDownListByIndex(WebElement element, int index){

        Select select = new Select(element);
        select.selectByIndex(index);
    }

    @Test

    public void testSearchPage () {

        driver.findElement(Locators.LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        Assert.assertEquals(currentUrlSearch, expectedUrlSearch);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
