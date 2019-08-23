import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseUI {

    String currentUrlSearch;

    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;

    @Test (priority = 2, enabled = testCase12, groups = {"ie"})

    public void testSearchPageTestCase12 () {
        Assert.assertTrue(driver.findElement (Locators.LINK_SEARCH).isDisplayed ()," Element is displayed");
        driver.findElement(Locators.LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        //Assert.assertEquals(currentUrlSearch, Data.expectedUrlSearch);
        softAssert.assertEquals (currentUrlSearch, Data.expectedUrlSearch, " Url is wrong");
        searchPage.searchForWomenTest ();
        softAssert.assertAll ();

    }

    @Test(priority = 3, enabled = testCase13, groups =  {"user", "admin"})
    public void verificationsTestCase13 (){
        Assert.assertEquals ("Web", "Web");
    }

    @Test(priority = 1, enabled = testCase11, groups = {"user", "admin"})
    public void selectRandomDropDownListTestCase11 (){
        driver.findElement (Locators.LINK_SEARCH).click ();
        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList (Locators.DROP_DOWN_LIST_SORT_BY_MAX_AGE);
        System.out.println (sizeOfDropDownListSortBy);
        for (int i = 0; i < 2; i++){
            searchPage.selectItemDropDownRandomOption (Locators.DROP_DOWN_LIST_SORT_BY_MAX_AGE, "Sort By Age");
            mainPage.javaWait (3);
        }
    }
    @Test
    public void selectRandomDropDownList(){
        driver.findElement (Locators.LINK_SEARCH).click ();
        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList (Locators.DROP_DOWN_LIST_SORT_BY_MIN_AGE);
        System.out.println (sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++){
            searchPage.selectItemDropDownRandomOption (Locators.DROP_DOWN_LIST_SORT_BY, "Sort by Age");
            mainPage.javaWaitSec (3);
        }
    }
}
